package com.gs.reusebook.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.DeliveryAddress;

public class UserTest {

	private UserService userService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		userService = (UserService) context.getBean("userService");
	}
	
//	@Test
	public void testChangePassword(){
		System.out.println(userService.changePassword("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", "97", "00"));
	}
	
//	@Test
	public void testAddAddress(){
		DeliveryAddress deliveryAddress = new DeliveryAddress();
		deliveryAddress.setAddress("nju");
		deliveryAddress.setId("1");
		deliveryAddress.setUserInfoId("1");
		
		System.out.println(userService.addAddress("0cc95799-4660-4758-9f7e-0053187eac7a", deliveryAddress));
	}
	
	@Test
	public void testDeleteAddress(){
		System.out.println(userService.deleteAddress("0cc95799-4660-4758-9f7e-0053187eac7a","1"));
	}
	
}
