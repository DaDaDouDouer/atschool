package com.gs.reusebook.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.util.UiReturn;
import static com.gs.reusebook.util.ReusebookStatic.TABLE_NAME_BOOK;

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
		
		List<String> typeIds = new ArrayList<String>();
//		typeIds.add("09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab");
		typeIds.add("111");
//		typeIds.add("112");
//		typeIds.add("113");
		
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("maxPrice", null);
		conditions.put("minPrice", "");
		conditions.put("sort", "");
		
		UiReturn goodses = goodsService.selectAndPaged("", 1,6, TABLE_NAME_BOOK, typeIds, conditions);
		System.out.println(goodses);
	}
	
//	@Test
	public void testGetRealGoods(){
		UiReturn realGoods = goodsService.getRealGoods("1");
		System.out.println(realGoods);
	}
}
