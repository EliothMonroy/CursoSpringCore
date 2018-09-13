package org.certificatic.spring.core.practica21.test.spel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.certificatic.spring.core.practica21.spel.model.PlaceOfBirth;
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
public class AssignmentTypesConstructorExpressionsTest_6 {

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
	public void assignmentExpressionsTest() {

		log.info("assignmentExpressionsTest -------------------");

		String teslaNameExpected = "Nikola Tesla";
		
		String teslaNameAfterChangeExpected = "Nikolai";

		String teslaName1 = spelParser.parseExpression("name").getValue(teslaContext, String.class);
		
		Assert.assertEquals(teslaNameExpected, teslaName1);
		
		log.info("teslaName1: {}", teslaName1);

		// -------------------------------------

		spelParser.parseExpression("name").setValue(teslaContext, "Nikolai"); // sólo analizar

		String teslaName2 = spelParser.parseExpression("name").getValue(teslaContext, String.class);
		
		Assert.assertNotEquals(teslaNameExpected, teslaName2);
		
		Assert.assertEquals(teslaNameAfterChangeExpected, teslaName2);
		
		log.info("teslaName2: {}", teslaName2);

		// -------------------------------------

		// definir una expresión que asigne y obtenga a la vez el nombre 'Nikola Tesla' sobre el nombre del Inventor Tesla
		String teslaName3 = spelParser.parseExpression(null).getValue(teslaContext, String.class);
		
		Assert.assertEquals(teslaNameExpected, teslaName3);
		
		log.info("teslaName3: {}", teslaName3);
	}

	@Test
	public void typesExpressionsTest() {

		log.info("typesExpressionsTest -------------------");

		Class<?> dateClass = spelParser.parseExpression("T(java.util.Date)").getValue(Class.class); // sólo analizar
		
		Assert.assertEquals(Date.class, dateClass);

		// definir una expresión que calcule el área de un circulo de 5.5 de radio (multiplicar y dividir por 1000.0 para truncar decimales
		Double circleArea = spelParser.parseExpression(null).getValue(Double.class);

		Assert.assertEquals(95.0332D, circleArea, 0.0001);
		
		// -------------------------------------

		Double doubleNumber = spelParser.parseExpression("T(Double).valueOf('95.0332')").getValue(Double.class); // sólo analizar
		
		Assert.assertEquals(95.0332D, doubleNumber, 0.0001);
	}

	@Test
	public void contructorExpressionsTest() {

		log.info("contructorExpressionsTest -------------------");

		double number = spelParser.parseExpression("1D").getValue(double.class);
		
		Assert.assertEquals(1, number, 0.0001);
		
		log.info("number: {}", number);

		// -------------------------------------

		GregorianCalendar c = spelParser.parseExpression("new java.util.GregorianCalendar()")
				.getValue(GregorianCalendar.class); // sólo analizar
		
		c.set(1879, 3, 14);

		StandardEvaluationContext context = new StandardEvaluationContext();
		
		context.setVariable("birthday", c);

		// definir y obtener el valor de una expresión que obtenga el valor (objeto) de un Inventor cuyos datos sean:
		// nombre: 'Albert Einstein', fecha de nacimiento: (la fecha definida en c) y nacionalidad: 'German'
		Inventor inventor = spelParser.parseExpression(null).getValue(context, Inventor.class);

		// definir y obtener el valor de una expresión que obtenga un arreglo de strings cuyos valores sean:
		// 'absorption refrigerator', 'quantum theory', 'theory of general relativity'
		String[] stringArray = spelParser.parseExpression(null).getValue(String[].class);

		inventor.setInventions(stringArray);

		PlaceOfBirth placeOfBirth = spelParser.parseExpression(
				"T(org.certificatic.spring.core.practica21.spel.model.PlaceOfBirth).builder().country('Germany').build()")
				.getValue(PlaceOfBirth.class); // sólo analizar

		inventor.setPlaceOfBirth(placeOfBirth);

		Inventor einstein = spelParser.parseExpression("getMember('Albert Einstein')").getValue(
				societyContext, Inventor.class); // sólo analizar

		Assert.assertEquals(einstein, inventor);

		log.info("einstein: {}", einstein);
		log.info("inventor: {}", inventor);

	}

}
