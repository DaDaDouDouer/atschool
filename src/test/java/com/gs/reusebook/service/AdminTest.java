package com.gs.reusebook.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.util.UiReturn;

public class AdminTest {

	private AuthAdminService authAdminService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		authAdminService = (AuthAdminService) context.getBean("authAdminService");
	}
	
	@Test
	public void testLogin(){
		UiReturn goodses = authAdminService.login("admin", "12345");
		System.out.println(goodses);
	}
	
}
