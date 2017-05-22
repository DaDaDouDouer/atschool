package com.gs.reusebook.filter;

import static com.gs.reusebook.util.GlobalStatus.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.GenericFilterBean;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Admin;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.util.UiReturn;

/**
 * 检查是否登录的过滤器
 * @author IceAsh
 *
 */
public class LoginCheckFilter extends GenericFilterBean{

	private final static String CONTROLLER_PACKAGE_PATH = "com.gs.reusebook.controller";
	
	/**
	 * java类文件编译之后的后缀
	 */
	private final static String CLASS_FILE_SUFIX = ".class";
	
	/**
	 * 存放所有需要验证的用户角色以及其对应的需要验证的url
	 */
	private Map<Class<? extends AuthBaseBean>, Set<String>> authBeansLimitedUris;
	
	/**
	 * 存放所有不需要经过登陆就能调用的url
	 */
	private Set<String> unlimitedUris;
	
	/**
	 * 自动扫描controller包下的controller，<br>
	 * 读取所有方法的SpringMVC路径并检查是否有需要登录的注解
	 */
	@Override
	protected void initFilterBean() throws ServletException {
		
		try {
			initLimitedURI();
		} catch (IOException e) {
			// TODO 打印日志
			e.printStackTrace();
		}
		
		super.initFilterBean();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		String requestUri = httpRequest.getRequestURI();

		// 如果调用的是非受限url则直接调用
		if(unlimitedUris.contains(requestUri)){
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = httpRequest.getSession();
		try{
			
			// 遍历当前系统中的角色，判断session中是否存在登陆的角色
			for(Class<? extends AuthBaseBean> characterClass : authBeansLimitedUris.keySet()){
				String characterId = (String) session.getAttribute(
						characterClass.newInstance().fatchIdSessionKey());
				
				// 如果某角色登陆，且拥有请求该url的权限，则通过请求，否则测试下个角色
				if(StringUtils.isNotEmpty(characterId) 
						&& authBeansLimitedUris.get(characterClass).contains(requestUri)){
					
					chain.doFilter(request, response);
					return;
				}
			}
			
			// 如果没有任何一个角色登陆，或者登陆的角色都没有请求该url的权限，则阻止请求
			response.getWriter().append(
					UiReturn.notOk("", "需要用户登录", NOT_VALIDATE_401).toJsonString());
			return;
			
		}catch(Exception e){
			// TODO 处理，日志
			e.printStackTrace();
		}
	}

	/**
	 * 扫描controller包路径下的所有controller文件，<br>
	 * 将需要登录才能调用的接口路径加入集合中
	 * @throws IOException
	 */
	private void initLimitedURI() throws IOException {
		// class类的集合
        Set<Class<?>> controllerClasses = new LinkedHashSet<Class<?>>();
        // 是否循环迭代
        boolean recursive = true;
        // 包路径
		String packageName = CONTROLLER_PACKAGE_PATH;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的文件夹或文件
		Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		// 循环迭代
		while (dirs.hasMoreElements()) {
			// 获取下一个元素
			URL url = dirs.nextElement();
			// 获取包的物理路径
			String packagePath = URLDecoder.decode(url.getFile(), "UTF-8");
			
			findAndAddClassesInPackageByFile(packageName, packagePath, recursive, controllerClasses);
			
		}
		
		/*
		 * 循环存放类的集合，检查类上是否有springMVC路径注解，如果有则获取，
		 * 之后获取类上的全部方法，检查方法上是否有springMVC路径注解，如果有则获取，
		 * 之后检查方法上是否有自定义登录检查注解，
		 * 如果有，则把类上的路径和方法上的路径合并再加上.do拼合成为请求路径的形式。
		 */
		unlimitedUris = new HashSet<String>();
		authBeansLimitedUris = new HashMap<Class<? extends AuthBaseBean>, Set<String>>();
		authBeansLimitedUris.put(User.class, new HashSet<String>());
		authBeansLimitedUris.put(Seller.class, new HashSet<String>());
		authBeansLimitedUris.put(Admin.class, new HashSet<String>());

		for(Class<?> clazz : controllerClasses){
			
			RequestMapping requestMappingOnClass = clazz.getAnnotation(RequestMapping.class);
			if(requestMappingOnClass != null){
				String[] pathValuesOnClass = requestMappingOnClass.value();
				
				Method[] methods = clazz.getMethods();
				for(Method method : methods){
					
					RequestMapping requestMappingOnMethod= method.getAnnotation(RequestMapping.class);
					if(requestMappingOnMethod != null){
						String[] pathValuesOnMethod = requestMappingOnMethod.value();
						
						/*
						 * 实际代码编写中，pathValuesOnClass和pathValuesOnMethod都只有一个值
						 * 但因为获取注解的方法返回值为数组，所以这里用遍历的写法
						 */
						for(int i = 0; i<pathValuesOnClass.length;i++){
							for(int j = 0; j<pathValuesOnMethod.length;j++){
								String url = pathValuesOnClass[i] + pathValuesOnMethod[j] + ".do";
								
								// 检查需要用户登录的注解
								NeedUserLogin needUserLogin = method.getAnnotation(NeedUserLogin.class);
								if(needUserLogin != null){
									List<Class<? extends AuthBaseBean>> characters = Arrays.asList(needUserLogin.character());
									// 如果接口需要登陆，则加入限制url集合中。不需要则加到不限制url集合。
									if(!characters.isEmpty()){
										for(Class<? extends AuthBaseBean> characterClass : characters){
											authBeansLimitedUris.get(characterClass).add(url);
										}
									}else{
										// TODO 此为系统异常，因为characterClass本应该有默认值
									}
								}else{
									unlimitedUris.add(url);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 扫描包路径下的所有文件，将其作为java类处理，获取class加入集合中<br>
	 * 可以递归调用
	 * 
	 * @param packageName 包名
	 * @param packagePath 包路径
	 * @param recursive 是否递归包下的文件夹
	 * @param classes 存放class的集合
	 * @throws IOException
	 */
	private void findAndAddClassesInPackageByFile(String packageName, String packagePath, 
			final boolean recursive, Set<Class<?>> classes) throws IOException {
		// 以文件的方式扫描整个包下的文件 并添加到集合中
		File dir = new File(packagePath);
		// 如果不存在或者或者不是目录就抛出异常
		if (!dir.exists() || !dir.isDirectory()) {
			throw new IOException("不存在该controller目录");
		}
		// 如果存在，就获取包下的所有文件，包括目录
		// 注意由于是在运行期获取文件，所以并不是.java而是.class，编译之后的
		File[] dirfiles = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return (file.isDirectory() && recursive) || (file.getName().endsWith(CLASS_FILE_SUFIX));
			}
		});
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(
						0, file.getName().length() - CLASS_FILE_SUFIX.length());
				try {
					// class添加到集合中去
					classes.add(Thread.currentThread().getContextClassLoader().loadClass(
									packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					throw new IOException("找不到文件对应的class类");
				}
			}
		}
	}
}
