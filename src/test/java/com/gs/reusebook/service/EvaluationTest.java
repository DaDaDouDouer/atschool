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
		System.out.println(evaluationService.addEvaluation("17718c86-e8ca-4a9d-96f3-f1a4a3da04ab", "1", "qewrew4334"));
	}
}
