package org.certificatic.spring.core.practica21.test.spel;

import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.QuadraticEquationResult;
import org.certificatic.spring.core.practica21.spel.bean.Chicharronera;
import org.certificatic.spring.core.practica21.spel.bean.GuessNumber;
import org.certificatic.spring.core.practica21.spel.bean.Magician;
import org.certificatic.spring.core.practica21.spel.bean.MyBeanResolver;
import org.certificatic.spring.core.practica21.spel.configuration.ApplicationConfig;
import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VariablesFunctionsBeanReferencesExpressionsTest_7 {

	private static ExpressionParser spelParser = new SpelExpressionParser();

	private static StandardEvaluationContext springContext;

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUp() {
		applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		springContext = new StandardEvaluationContext();
		
		// asignar al 'springContext' el bean resolver 'MyBeanResolver' que se encuentra en el application context
		springContext.setBeanResolver(new BeanResolver() {
			
			@Override
			public Object resolve(EvaluationContext context, String beanName) throws AccessException {
				// TODO Auto-generated method stub
				System.out.println("Solicitando bean:"+beanName);
				return applicationContext.getBean(beanName);
			}
		});
	}

	@Test
	public void variablesExpressionsTest() {

		log.info("variablesExpressionsTest -------------------");

		Magician magician = applicationContext.getBean(Magician.class);

		springContext.setVariable("magicNumber", magician.getInitialNumber()); // s�lo analizar

		// defnir y obtener el valor de una expresi�n que acceda al bean gessNumberBean definido en el aplication-context.xml
		// y recupere el valor de la propiedad randomNumber
		Integer randomNumber = spelParser.parseExpression("@guessNumber.Bean.randomNumber").getValue(springContext, Integer.class);

		springContext.setVariable("randomNumber", randomNumber); // s�lo analizar

		// -------------------------------------

		Boolean isCorrectNumber = spelParser.parseExpression("#randomNumber == #magicNumber").getValue(springContext,
				Boolean.class); // s�lo analizar
		
		Assert.assertNotNull(isCorrectNumber);
		
		log.info("isCorrectNumber: {}", isCorrectNumber);

		log.info("magician.initialNumber: {}", magician.getInitialNumber());
		
		log.info("gessNumberBean.randomNumber: {}", randomNumber);
	}

	@Test
	@SneakyThrows
	public void functionsExpressionsTest() {

		log.info("functionsExpressionsTest -------------------");

		// analizar setVariable's
		springContext.setVariable("a", 5);
		springContext.setVariable("b", 4);
		springContext.setVariable("c", -10);

		// registra una funci�n llamada 'chicharronera' que invoque al m�todo 'calculate' de la clase Chicharronera
		springContext.registerFunction("chicharronera", Chicharronera.class.getDeclaredMethod("calculate", double.class,double.class,double.class));

		QuadraticEquationResult expectedResult = QuadraticEquationResult.builder().x1(new Complex(1.0697, 0.0))
				.x2(new Complex(-1.8697, 0.0)).build(); // s�lo analiza

		// definir y obtener el valor de la expresi�n que invoque a la funci�n 'chicharronera' tomando como argumentos
		// las variables 'a', 'b' y 'c'
		QuadraticEquationResult quadraticEquationResult = spelParser.parseExpression(
				"#chicharronera(#a,#b,#c)").getValue(springContext, QuadraticEquationResult.class);

		Assert.assertNotNull(quadraticEquationResult);
		
		Assert.assertEquals(expectedResult, quadraticEquationResult);
		
		log.info("quadraticEquationResult: {}", quadraticEquationResult);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void beanReferencesExpressionsTest() {

		log.info("beanReferencesExpressionsTest -------------------");

		GuessNumber guessNumber = spelParser.parseExpression("@gessNumberBean").getValue(springContext,
				GuessNumber.class); //s�lo analiza
		
		Assert.assertNotNull(guessNumber);
		
		log.info("guessNumber: {}", guessNumber);

		// -------------------------------------

		Inventor tesla = spelParser.parseExpression("@teslaBean").getValue(springContext,
				Inventor.class); //s�lo analiza
		
		Assert.assertNotNull(tesla);
		
		log.info("tesla: {}", tesla);

		// -------------------------------------

		Integer inventionsLength = spelParser.parseExpression("@teslaBean.inventions.length").getValue(springContext,
				int.class); //s�lo analiza
		
		Assert.assertNotNull(inventionsLength);
		
		log.info("inventionsLength: {}", inventionsLength);

		// -------------------------------------

		List<String> inventions = spelParser.parseExpression("@teslaBean.inventions").getValue(springContext,
				List.class); //s�lo analiza
		
		Assert.assertNotNull(inventions);
		
		log.info("inventions: {}", inventions);

		Assert.assertEquals(3, inventions.size());
	}

}
