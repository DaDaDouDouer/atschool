package com.gs.reusebook.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.Goods;
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
	public void testSelectBySellerId(){
		System.out.println(goodsService.selectAndPagedBySellerId("", "31c0d96d-0e94-4a52-8648-9c39009d5a72", 1, 4));
	}
	
//	@Test
	public void testGetRealGoods(){
		UiReturn realGoods = goodsService.getRealGoods("1");
		System.out.println(realGoods);
	}
	
//	@Test
	public void testUpdateField(){
		System.out.println(goodsService.updateGoodsField("1", Goods.COLUMN_NAME_DESCRIPTION, "adesp", "17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
	
//	@Test
	public void testAddGoods(){
		Goods goods = new Goods();
		goods.setCount(1);
		goods.setId("7");
		goods.setImgUrl("http://img3x9.ddimg.cn/94/4/21127189-1_w_2.jpg");
		goods.setLinkTable("tab_book");
		goods.setName("测试书籍");
		goods.setRealGoodsId("14");
		goods.setPrice(10.2);
		goods.setVia(0);
		goodsService.addGoods(goods, "17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", "njuptseller");
	}
//	@Test
	public void testAddGoodsByIsbn(){
		goodsService.addGoodsByIsbn("9787121287220", 12.2, 10, "1", "njuptseller");
	}
}
