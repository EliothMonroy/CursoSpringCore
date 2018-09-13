package org.certificatic.spring.core.practica21.test.spel;

import org.certificatic.spring.core.practica21.spel.bean.MyBeanResolver;
import org.certificatic.spring.core.practica21.spel.configuration.ApplicationConfig;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplatingExpressionsTest_9 {

	private static ExpressionParser spelParser = new SpelExpressionParser();

	private static StandardEvaluationContext springContext;

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUp() {
		applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		springContext = new StandardEvaluationContext();
		springContext.setBeanResolver(applicationContext.getBean(MyBeanResolver.class));
	}

	@Test
	public void templatingExpressionsTest() {

		log.info("templatingExpressionsTest -------------------");

		springContext.setVariable("name", "Ivan García");

		String greeting = spelParser.parseExpression("Hi #{ #name +' '+'you''re' } awesome!", new TemplateParserContext())
				.getValue(springContext,String.class); // sólo analiza

		Assert.assertNotNull(greeting);
		
		Assert.assertEquals("Hi Ivan García you're awesome!", greeting);
		
		log.info("greeting: {}", greeting);
	}
	
	@Test
	public void templatingExpressionsTest2() {

		log.info("templatingExpressionsTest2 -------------------");

		springContext.setVariable("name", "Ivan García");

		String greeting = spelParser.parseExpression("Hi %[[ #name +' '+'you''re' ]] awesome!", new TemplateParserContext("%[[","]]"))
				.getValue(springContext,String.class); // sólo analiza

		Assert.assertNotNull(greeting);
		
		Assert.assertEquals("Hi Ivan García you're awesome!", greeting);
		
		log.info("greeting: {}", greeting);
	}

}
