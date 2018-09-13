package org.certificatic.spring.core.practica21.test.spel;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LiteralExpressionsTest_2 {

	@Test
	public void literalExpressionsTest1() {

		log.info("literalExpressionsTest1 -------------------");

		ExpressionParser spelParser = new SpelExpressionParser();

		Expression spelExpression = spelParser.parseExpression("'Ivan García'");

		String stringExpression = null; // obtener valor de la expresion

		Assert.assertEquals("Ivan García", stringExpression);

		log.info("stringExpression: {}", stringExpression);
	}

	@Test
	public void literalExpressionsTest2() {

		log.info("literalExpressionsTest2 -------------------");

		ExpressionParser spelParser = new SpelExpressionParser();

		double doubleValue = 0.0; // definir y obtener el valor de la expresion
									// "3.1416E+10"

		Assert.assertEquals(3.1416E10, doubleValue, 0.0001);

		log.info("doubleValue: {}", doubleValue);
	}

	@Test
	public void literalExpressionsTest3() {

		log.info("literalExpressionsTest3 -------------------");

		ExpressionParser spelParser = new SpelExpressionParser();

		int maxIntValue = (Integer) spelParser.parseExpression("0x7FFFFFFF")
				.getValue();

		Assert.assertEquals(2147483647, maxIntValue);

		log.info("maxIntValue: {}", maxIntValue);

		boolean trueValue = (Boolean) spelParser.parseExpression("true")
				.getValue();

		Assert.assertTrue(trueValue);

		log.info("trueValue: {}", trueValue);

		Object nullObject = (Object) spelParser.parseExpression("null")
				.getValue();

		Assert.assertNull(nullObject);

		log.info("nullObject: {}", nullObject);
	}
}
