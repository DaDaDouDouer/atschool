package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.bean.GoodsType;

public class BookTest {

	private BookService bookService;
	private GoodsTypeService GoodsTypeService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		bookService = (BookService) context.getBean("bookService");
		GoodsTypeService = (GoodsTypeService) context.getBean("goodsTypeService");
	}
	
	@Test
	public void testGetAllType(){
		System.out.println(GoodsTypeService.selectAll());
	}
	
//	@Test
	public void testGetTypeByLinkTable(){
		System.out.println(GoodsTypeService.selectByLinkTable("tab_book"));
	}
}
