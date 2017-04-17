package com.gs.reusebook.connect;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookConnectTest {
	private BookConnect bookConnect;	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		bookConnect = (BookConnect) context.getBean("bookConnect");
	}
	@Test
	public void testGetBookInformation(){
		bookConnect.getBookInformation("9787115433947");
	}

}
