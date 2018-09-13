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
public class MethodExpressionsTest_4 {

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
	public void methodExpressionsTest() {

		log.info("methodExpressionsTest -------------------");

		// definir expresión substring que obtenga el valor esperado de Tesla
		String teslaFirstName = (String) spelParser.parseExpression(null).getValue(teslaContext);
		
		Assert.assertEquals("Nikola", teslaFirstName);
		
		log.info("teslaFirstName: {}", teslaFirstName);

		// -------------------------------------
		
		// definir expresión que verifique si el 'Rudolf Carl Virchow' es miebro de la sociedad IEEE
		boolean isMemberRudolfCarlVirchow = (boolean) spelParser.parseExpression(null).getValue(societyContext);
		
		Assert.assertFalse(isMemberRudolfCarlVirchow);
		
		log.info("isMember RudolfCarlVirchow: {}", isMemberRudolfCarlVirchow);

		// -------------------------------------

		// definir expresión que verifique si el 'Charles Babbage' es miebro de la sociedad IEEE
		boolean isMemberCharlesBabbage = (boolean) spelParser.parseExpression(null).getValue(societyContext);
		
		Assert.assertTrue(isMemberCharlesBabbage);
		
		log.info("isMember CharlesBabbage: {}", isMemberCharlesBabbage);

		// -------------------------------------

		// method with if then else.
		String charlesBabage = "Charles Babbage";
		
		// definir la variable "inventor" con el nombre de "Charles Babbage" y agregarla al contexto sociedad IEEE
		
		// analizar
		String isMemberCharlesBabbageString = spelParser
				.parseExpression("isMember(#inventor) ? #inventor + ' is member !' : #inventor + ' isn''t member.'")
				.getValue(societyContext, String.class);
		
		Assert.assertEquals(charlesBabage + " is member !", isMemberCharlesBabbageString);
		
		log.info("isMember CharlesBabbageString: {}", isMemberCharlesBabbageString);

	}
}
