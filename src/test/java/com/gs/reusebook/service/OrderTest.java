package com.gs.reusebook.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderTest {

	private OrderService orderService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		orderService = (OrderService) context.getBean("orderService");
	}
	
	@Test
	public void insertOrder(){
		Map<String, Integer> goodsIdAndCount = new HashMap<String, Integer>();
		goodsIdAndCount.put("1", 1);
		goodsIdAndCount.put("2", 2);
		System.out.println(orderService.insertOrder("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", goodsIdAndCount, "jia"));
	}
	
//	@Test
	public void getOrder(){
		System.out.println(orderService.selectAllBySellerId("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
		System.out.println(orderService.selectAllByUserId("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
}
