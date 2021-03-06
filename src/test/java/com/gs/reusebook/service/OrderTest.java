package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	
//	@Test
	public void insertOrder(){
		Map<String, Integer> goodsIdAndCount = new HashMap<String, Integer>();
		goodsIdAndCount.put("3", 1);
		System.out.println(orderService.insertOrder("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", goodsIdAndCount, "jia"));
	}
	
//	@Test
	public void getOrder(){
//		System.out.println(orderService.selectAllBySellerId("","31c0d96d-0e94-4a52-8648-9c39009d5a72", 1, 2));
		System.out.println(orderService.selectAllByUserId("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", 1, 2));
	}
	
	@Test
	public void payAll(){
		System.out.println(
				orderService.payAll(new ArrayList<String>(
				Arrays.asList("3974de48-a93f-4e82-943b-ebbdfd676343","dcb47ad6-1b73-4cf1-a652-41a6b32102da")), 
				"17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
	
}
