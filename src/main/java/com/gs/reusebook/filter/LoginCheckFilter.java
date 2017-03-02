package com.gs.reusebook.filter;

import static com.gs.reusebook.util.ReusebookStatic.*;
import static com.gs.reusebook.util.GlobalStatus.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
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
	 * 存放所有需要一般用户登录才能访问的接口路径
	 */
	private List<String> limitedURIForUser;

	/**
	 * 存放所有需要商家登录才能访问的接口路径
	 */
	private List<String> limitedURIForSeller;
	
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
		
		// 保存用户的登录验证状态
		boolean isLogin = true;
		
		// 一般用户登录检查
		if(limitedURIForUser.contains(requestUri)){
			HttpSession session = httpRequest.getSession();
			
			// 检查session中是否有登录之后的信息
			String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
			
			if(StringUtils.isEmpty(userId)){
				response.getWriter().append(
						UiReturn.notOk("", "需要一般用户登录", NOT_VALIDATE_401).toJsonString());
				isLogin = false;
			}
		}

		// TODO 此处重复代码可优化
		// 商户登录检查
		if(limitedURIForSeller.contains(requestUri)){
			HttpSession session = httpRequest.getSession();
			
			// 检查session中是否有登录之后的信息
			String sellerId= (String) session.getAttribute(SELLER_ID_SESSION_KEY);
			
			if(StringUtils.isEmpty(sellerId)){
				response.getWriter().append(
						UiReturn.notOk("", "需要商家用户登录", NOT_VALIDATE_401).toJsonString());
				isLogin = false;
			}
		}
		
		// 如果在执行了response.getWriter().append()后再调用doFilter会导致报错
		if(isLogin){
			chain.doFilter(request, response);
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
		Enumeration<URL> dirs = 
				Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		// 循环迭代
		while (dirs.hasMoreElements()) {
			// 获取下一个元素
			URL url = dirs.nextElement();
			// 获取包的物理路径
			String packagePath = URLDecoder.decode(url.getFile(), "UTF-8");
			
			findAndAddClassesInPackageByFile(packageName, packagePath,
                    recursive, controllerClasses);
			
		}
		
		/*
		 * 循环存放类的集合，检查类上是否有springMVC路径注解，如果有则获取，
		 * 之后获取全部方法，检查方法上是否有springMVC路径注解，如果有则获取，
		 * 之后检查方法上是否有自定义登录检查注解，
		 * 如果有，则把类上的路径和方法上的路径合并再加上.do拼合成为请求路径的形式。
		 */
		limitedURIForUser = new ArrayList<String>();
		limitedURIForSeller = new ArrayList<String>();
		for(Class<?> clazz : controllerClasses){
			
			RequestMapping requestMappingOnClass = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
			if(requestMappingOnClass != null){
				String[] pathValuesOnClass = requestMappingOnClass.value();
				
				Method[] methods = clazz.getMethods();
				for(Method method : methods){
					
					// 检查需要用户登录的注解
					NeedUserLogin needUserLogin = (NeedUserLogin) method.getAnnotation(NeedUserLogin.class);
					if(needUserLogin != null){
						RequestMapping requestMappingOnMethod= (RequestMapping) method.getAnnotation(RequestMapping.class);
						if(requestMappingOnMethod != null){
							String[] pathValuesOnMethod = requestMappingOnMethod.value();
							
							for(int i = 0; i<pathValuesOnClass.length;i++){
								for(int j = 0; j<pathValuesOnMethod.length;j++){
									List<Class<? extends AuthBaseBean>> characters = Arrays.asList(needUserLogin.character());
									if(!characters.isEmpty()){
										for(Class<? extends AuthBaseBean> characterClass : characters){
											
											if(characterClass == User.class){
												limitedURIForUser.add(pathValuesOnClass[i] + pathValuesOnMethod[j] + ".do");
											}
											
											if(characterClass == Seller.class){
												limitedURIForSeller.add(pathValuesOnClass[i] + pathValuesOnMethod[j] + ".do");
											}
											// 之后如果还有bean是需要登陆验证的则写在这里
										}
									}
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
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), 
						file.getAbsolutePath(), recursive, classes);
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
