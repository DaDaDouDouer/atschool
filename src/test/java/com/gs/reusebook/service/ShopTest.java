package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.Shop;

public class ShopTest {

	private ShopService shopService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		shopService = (ShopService) context.getBean("shopService");
	}
	
//	@Test
	public void testAdd(){
		System.out.println(shopService.add("two b", "17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
	
	@Test
	public void testUpdate(){
		String[] ids = new String[]{"1", "3", "4", "5"};
		System.out.println(
				shopService.updateGoodIds(Shop.RECOMMAND_NAME, 
				new ArrayList<String>(Arrays.asList(ids)),
				"17718c86-e8ca-4a9d-96f3-f1a4a3da04ab")
				);
	}
	
//	@Test
	public void testGet(){
		System.out.println(shopService.getBySellerId("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
}
