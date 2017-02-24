package com.gs.reusebook.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;import com.sun.org.apache.xml.internal.security.encryption.CipherData;

public class CartItemTest {

	private CartItemService cartItemService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		cartItemService = (CartItemService) context.getBean("cartItemService");
	}
	
//	 @Test
	public void testAddCartItem(){
		System.out.println(cartItemService.addToCart("0cc95799-4660-4758-9f7e-0053187eac7a","3" , 3));
	}
	

//	 @Test
	public void testDeleteCartItem(){
		System.out.println(cartItemService.deleteCartItem("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", "69ba6683-911c-4ae8-8a25-0ba7129123fc"));
	}

//	 @Test
	public void testUpdateGoodsCount(){
		System.out.println(cartItemService.updateGoodsCount
				("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", "69ba6683-911c-4ae8-8a25-0ba7129123fc", 10));
	}

	 @Test
	public void testSelectAll(){
		System.out.println(cartItemService.selectAll("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab"));
	}
	
}
