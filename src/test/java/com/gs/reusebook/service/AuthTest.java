package com.gs.reusebook.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuthTest {

	private AuthUserService authUserService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		authUserService = (AuthUserService) context.getBean("authUserService");
	}
	
	@Test
	public void testRegister(){
		System.out.println(authUserService.register("qiaojuyang", "123", "906380576@qq.com"));
	}
}
