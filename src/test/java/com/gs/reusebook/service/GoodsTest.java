package com.gs.reusebook.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.Goods;

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
		List<Goods> goodses = goodsService.selectAndPagedByName("%%", 2, 3);
		System.out.println(goodses);
	}
}
