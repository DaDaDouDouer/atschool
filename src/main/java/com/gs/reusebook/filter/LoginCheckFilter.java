package com.gs.reusebook.filter;

import static com.gs.reusebook.util.ReusebookStatic.USER_ID_SESSION_KEY;
import static com.gs.reusebook.util.GlobalStatus.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
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
import com.gs.reusebook.util.UiReturn;

/**
 * 检查是否登录的过滤器
 * @author IceAsh
 *
 */
public class LoginCheckFilter extends GenericFilterBean{

	private final static String CONTROLLER_PACKAGE_PATH = "com.gs.reusebook.controller";
	/**
	 * 存放所有需要登录才能访问的接口路径
	 */
	private List<String> limitedURI;
	
	/**
	 * 自动扫描controller包下的controller，<br>
	 * 读取所有方法的StringMVC路径并检查是否有需要登录的注解
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
		
		String uri = httpRequest.getRequestURI();
		
		if(limitedURI.contains(uri)){
			HttpSession session = httpRequest.getSession();
			String userId= (String) session.getAttribute(USER_ID_SESSION_KEY);
			
			if(StringUtils.isEmpty(userId)){
				response.getWriter().append(
						UiReturn.notOk("", "需要登录", NOT_VALIDATE_401).toJsonString());
			}else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * 扫描controller包路径下的所有controller文件，<br>
	 * 将需要登录才能调用的接口路径加入集合中
	 * @throws IOException
	 */
	private void initLimitedURI() throws IOException {
		// 第一个class类的集合
        Set<Class<?>> controllerClasses = new LinkedHashSet<Class<?>>();
        // 是否循环迭代
        boolean recursive = true;
        // 包路径
		String packageName = CONTROLLER_PACKAGE_PATH;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		// 循环迭代下去
		while (dirs.hasMoreElements()) {
			// 获取下一个元素
			URL url = dirs.nextElement();
			// 获取包的物理路径
			String packagePath = URLDecoder.decode(url.getFile(), "UTF-8");
			
			findAndAddClassesInPackageByFile(packageName, packagePath,
                    recursive, controllerClasses);
			
		}

		limitedURI = new ArrayList<String>();
		for(Class<?> clazz : controllerClasses){
			
			RequestMapping requestMappingOnClass = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
			if(requestMappingOnClass != null){
				String[] pathValuesOnClass = requestMappingOnClass.value();
				
				Method[] methods = clazz.getMethods();
				for(Method method : methods){
					
					NeedUserLogin needUserLogin = (NeedUserLogin) method.getAnnotation(NeedUserLogin.class);
					if(needUserLogin != null){
						RequestMapping requestMappingOnMethod= (RequestMapping) method.getAnnotation(RequestMapping.class);
						if(requestMappingOnMethod != null){
							String[] pathValuesOnMethod = requestMappingOnMethod.value();
							
							for(int i = 0; i<pathValuesOnClass.length;i++){
								for(int j = 0; j<pathValuesOnMethod.length;j++){
									limitedURI.add(pathValuesOnClass[i] + pathValuesOnMethod[j] + ".do");
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
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					throw new IOException("找不到此类的.class文件");
				}
			}
		}
	}
}
