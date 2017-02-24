package com.gs.reusebook.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EvaluationTest {

	private EvaluationService evaluationService;
	
	@Before
	public void before(){  
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		evaluationService = (EvaluationService) context.getBean("evaluationService");
	}
	
	@Test
	public void testSelectAll(){
		System.out.println(evaluationService.selectAll("3"));
	}
	
//	@Test
	public void testAdd(){
		System.out.println(evaluationService.addEvaluation("0cc95799-4660-4758-9f7e-0053187eac7a", "3", "sdftt65676yut"));
	}
}
