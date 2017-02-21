package com.gs.reusebook.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.User;

public class TestTest {

	private UserService userService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		userService = (UserService) context.getBean("userService");
	}
	
	@Test
	public void insertUser(){
		List<User> users = userService.selectUserWithCartItems("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab");
		System.out.println(users);
	}
}
