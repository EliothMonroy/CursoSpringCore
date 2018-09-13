package org.certificatic.spring.core.practica21.test.spel;

import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.certificatic.spring.core.practica21.test.spel.model.stub.SocietyStub;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperatorsExpressionsTest_5 {

	private static ExpressionParser spelParser = new SpelExpressionParser();

	private static EvaluationContext teslaContext;
	private static EvaluationContext societyContext;

	@BeforeClass
	public static void setUp() {
		Inventor tesla = SocietyStub.createTesla();
		teslaContext = new StandardEvaluationContext(tesla);

		societyContext = new StandardEvaluationContext(
				SocietyStub.createSociety("IEEE"));
	}

	@Test
	public void relationalOperatorsExpressionsTest() {

		log.info("relationalOperatorsExpressionsTest -------------------");

		boolean booleanTrueExpression = (Boolean) spelParser.parseExpression("2 == 2").getValue();
		
		Assert.assertTrue(booleanTrueExpression);
		
		log.info("2 == 2: {}", booleanTrueExpression);

		// -------------------------------------

		booleanTrueExpression = (Boolean) spelParser.parseExpression("2 eq 2").getValue();
		
		Assert.assertTrue(booleanTrueExpression);
		
		log.info("2 eq 2: {}", booleanTrueExpression);

		// -------------------------------------

		boolean booleanFalseExpression = (Boolean) spelParser.parseExpression("2 < 2").getValue();
		
		Assert.assertFalse(booleanFalseExpression);
		
		log.info("2 < 2: {}", booleanFalseExpression);

		// -------------------------------------

		booleanFalseExpression = (Boolean) spelParser.parseExpression("2 lt 2").getValue();
		
		Assert.assertFalse(booleanFalseExpression);
		
		log.info("2 lt 2: {}", booleanFalseExpression);

		// -------------------------------------

		boolean stringBooleanExpression = spelParser.parseExpression("'black' < 'block'").getValue(Boolean.class);
		
		Assert.assertTrue(stringBooleanExpression);
		
		log.info("'black' < 'block': {}", stringBooleanExpression);

		// -------------------------------------

		stringBooleanExpression = spelParser.parseExpression("'black' lt 'block'").getValue(Boolean.class);
		
		Assert.assertTrue(stringBooleanExpression);
		
		log.info("'black' lt 'block': {}", stringBooleanExpression);
	}

	@Test
	public void instanceofExpressionsTest() {

		log.info("instanceofExpressionsTest -------------------");

		boolean booleanInstanceofIntExpression = (Boolean) spelParser.parseExpression("'xyz' instanceof T(Integer)")
				.getValue();
		
		Assert.assertFalse(booleanInstanceofIntExpression);
		
		log.info("'xyz' instanceof T(Integer): {}", booleanInstanceofIntExpression);

		// -------------------------------------

		boolean booleanInstanceofStringExpression = (Boolean) spelParser
				.parseExpression("'123' instanceof T(java.lang.String)").getValue();
		
		Assert.assertTrue(booleanInstanceofStringExpression);
		
		log.info("'123' instanceof T(java.lang.String): {}", booleanInstanceofStringExpression);

		// -------------------------------------

		// instanceof an logical operators
		EvaluationContext context = new StandardEvaluationContext();
		
		context.setVariable("two", 2);
		
		booleanInstanceofStringExpression = (Boolean) spelParser
				.parseExpression("2 instanceof T(java.lang.Integer) and #two instanceof T(Integer)").getValue(context);
		
		Assert.assertTrue(booleanInstanceofStringExpression);
		
		log.info("2 instanceof T(java.lang.Integer) and #two instanceof T(Integer): {}",
				booleanInstanceofStringExpression);

	}

	@Test
	public void logicalOperatorsExpressionsTest() {

		log.info("logicalOperatorsExpressionsTest -------------------");

		boolean booleanExpression = (Boolean) spelParser.parseExpression("true and false").getValue();
		
		Assert.assertFalse(booleanExpression);
		
		log.info("true and false: {}", booleanExpression);

		// -------------------------------------

		booleanExpression = (Boolean) spelParser
				.parseExpression("isMember('Anatoly Alexandrov') and isMember('Bruce Ames')").getValue(societyContext);
		
		Assert.assertTrue(booleanExpression);
		
		log.info("isMember('Anatoly Alexandrov') and isMember('Bruce Ames'): {}", booleanExpression);
		
		// -------------------------------------

		booleanExpression = (Boolean) spelParser.parseExpression("true or false")
				.getValue();
		
		Assert.assertTrue(booleanExpression);
		
		log.info("true or false: {}", booleanExpression);

		// -------------------------------------

		booleanExpression = (Boolean) spelParser.parseExpression("! false")
				.getValue();
		
		Assert.assertTrue(booleanExpression);
		
		log.info("! false: {}", booleanExpression);
	}

	@Test
	public void mathematicalOperatorsExpressionsTest() {

		log.info("mathematicalOperatorsExpressionsTest -------------------");

		Integer integerValue = (Integer) spelParser.parseExpression("1 + 2 + 3")
				.getValue();
		
		Assert.assertEquals((Integer) 6, integerValue);
		
		log.info("1 + 2 + 3: {}", integerValue);

		// -------------------------------------

		integerValue = (Integer) spelParser.parseExpression("5 - -5")
				.getValue();
		
		Assert.assertEquals((Integer) 10, integerValue);
		
		log.info("5 - -5: {}", integerValue);

		// -------------------------------------

		Double doubleValue = (Double) spelParser.parseExpression("3.5 * 2.5 / -5")
				.getValue();
		
		Assert.assertEquals(-1.75D, doubleValue, 0.001);
		
		log.info("3.5 * 2.5 / -5: {}", doubleValue);
	}

}
