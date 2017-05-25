package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		System.out.println(shopService.add("tworr b", "17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
	
//	@Test
	public void testUpdate(){
		String[] ids = new String[]{"1"};
		System.out.println(
				shopService.updateGoodIds(Shop.RECOMMAND_NAME, 
				new ArrayList<String>(Arrays.asList(ids)),
				"17718c86-e8ca-4a9d-96f3-f1a4a3da04ab")
				);
	}
	
//	@Test
	public void testGet(){
		System.out.println(shopService.getBySellerId("31c0d96d-0e94-4a52-8648-9c39009d5a72"));
	}
	
//	@Test
	public void testAddRecommand(){
		System.out.println(shopService.addRecommand("4", "31c0d96d-0e94-4a52-8648-9c39009d5a72"));
	}

//	@Test
	public void testRemoveRecommand(){
		System.out.println(shopService.removeRecommand("4", "31c0d96d-0e94-4a52-8648-9c39009d5a72"));
	}

	@Test
	public void testAddCarousel(){
		
		Map<String, String> entry = new HashMap<String, String>();
		entry.put(Shop.CAROUSEL_URL, "com2");
		entry.put(Shop.CAROUSEL_DESC, "描述2");
		System.out.println(shopService.addCarousel(entry, "31c0d96d-0e94-4a52-8648-9c39009d5a72"));
	}

//	@Test
	public void testRemoveCarousel(){
		System.out.println(shopService.removeCarousel("com", "31c0d96d-0e94-4a52-8648-9c39009d5a72"));
	}
}
