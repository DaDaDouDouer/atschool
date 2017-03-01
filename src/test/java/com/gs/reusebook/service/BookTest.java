package com.gs.reusebook.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gs.reusebook.bean.Book;
import com.gs.reusebook.bean.BookType;

public class BookTest {

	private BookService bookService;
	private BookTypeService bookTypeService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		bookService = (BookService) context.getBean("bookService");
		bookTypeService = (BookTypeService) context.getBean("bookTypeService");
	}
	
	@Test
	public void testSelectByCondition(){
		Book book = new Book();
		List<BookType> types = new ArrayList<BookType>();
		BookType type = new BookType();
		type.setId("112");
		types.add(type);
		book.setTypes(types);
		
		System.out.println(bookService.selectByBookCondition(book));
	}
//	@Test
	public void testGetAllType(){
		System.out.println(bookTypeService.SelectAll());
	}
	
}
