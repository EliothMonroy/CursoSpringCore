package org.certificatic.spring.core.practica21.test.spel;

import java.util.Random;

import org.certificatic.spring.core.practica21.spel.bean.MyBeanResolver;
import org.certificatic.spring.core.practica21.spel.configuration.ApplicationConfig;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TernaryElvisAndSelfNavigationOperatorsExpressionsTest_8 {

	private static ExpressionParser spelParser = new SpelExpressionParser();

	private static StandardEvaluationContext springContext;

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUp() {
		applicationContext = new AnnotationConfigApplicationContext(
				ApplicationConfig.class);

		springContext = new StandardEvaluationContext();
		springContext.setBeanResolver(applicationContext.getBean(MyBeanResolver.class));
	}

	@Test
	public void ternaryOperatorExpressionsTest() {

		log.info("templatingExpressionsTest -------------------");

		springContext.setVariable("random", new Random());

		// define una expresión con operador ternario que devuelva un string u otro dependiendo si el 'nextInt' del objeto random
		// es par o impar.
		String greeting = spelParser.parseExpression(null).getValue(springContext, String.class);

		Assert.assertNotNull(greeting);

		log.info("greeting: {}", greeting);
	}

	@Test
	public void elvisOperatorExpressionsTest() {

		log.info("elvisOperatorExpressionsTest -------------------");

		springContext.setVariable("name", "Ivan García");

		// define una expresión con operador elvis que verifique si es nula la variable 'name'
		// si es nula imprimir 'Without me'
		String name = spelParser.parseExpression(null).getValue(springContext, String.class);
		
		Assert.assertNotNull(name);
		
		Assert.assertEquals("Ivan García", name);
		
		log.info("name: {}", name);

		// -------------------------------------

		spelParser.parseExpression("#name").setValue(springContext, null);

		// define la misma expresión anterior y comprueba el resultado
		name = spelParser.parseExpression(null).getValue(springContext, String.class);
		
		Assert.assertNotNull(name);
		
		Assert.assertEquals("Without name", name);
		
		log.info("name: {}", name);
		
		// -------------------------------------

		name = spelParser.parseExpression("#name").getValue(springContext, String.class); // sólo analiza
		
		Assert.assertNull(name);
		
		log.info("name: {}", name);
		
		// -------------------------------------

		name = spelParser.parseExpression("#name2").getValue(springContext, String.class); // sólo analiza
		
		Assert.assertNull(name);
		
		log.info("name: {}", name);
	}

	@Test(expected = SpelEvaluationException.class)
	public void selfNavigationOperatorExpressionsTest2() {

		log.info("selfNavigationOperatorExpressionsTest2 -------------------");

		springContext.setVariable("name", "Ivan García");

		// define una expresión con operador 'self-navigation' que obtenga un substring que devuelva el valor 'Ivan'
		String name = spelParser.parseExpression(null).getValue(springContext, String.class);
		
		Assert.assertNotNull(name);
		
		Assert.assertEquals("Ivan", name);
		
		log.info("name: {}", name);

		// -------------------------------------

		spelParser.parseExpression("#name").setValue(springContext, null);

		// define la misma expresión anterior y comprueba el resultado
		name = spelParser.parseExpression(null).getValue(springContext, String.class);
		
		Assert.assertNull(name);
		
		log.info("name: {}", name);
		
		// -------------------------------------

		name = spelParser.parseExpression("#name.substring(0,4)")
				.getValue(springContext, String.class); // sólo analiza

		Assert.fail();
	}

}
