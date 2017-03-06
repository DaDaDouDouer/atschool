package com.gs.reusebook.service;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.util.UiReturn;

public class GoodsTest {

	private GoodsService goodsService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		goodsService = (GoodsService) context.getBean("goodsService");
	}
	
	@Test
	public void testSelectAndPagedByName(){
		UiReturn goodses = goodsService.selectAndPagedByName("p", 1, 2);
		System.out.println(goodses);
	}
	
//	@Test
	public void testGetRealGoods(){
		UiReturn realGoods = goodsService.getRealGoods("1");
		System.out.println(realGoods);
	}
}
