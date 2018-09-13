package org.certificatic.spring.core.practica21.test.spel;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.certificatic.spring.core.practica21.spel.model.PlaceOfBirth;
import org.certificatic.spring.core.practica21.test.spel.model.stub.SocietyStub;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesArraysListsMapsAndIndexersExpressionsTest_3 {

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
	public void propertiesSpelTest() {

		log.info("propertiesSpelTest -------------------");

		String teslaName = null; // definir y obtener el valor de la expresion "name" en el contexto teslaContext
		
		Assert.assertEquals("Nikola Tesla", teslaName);
		
		log.info("teslaName: {}", teslaName);

		// -------------------------------------
		
		int teslaBirthYear = 0; // definir y obtener el valor de la expresion "birthdate.year + 1900" en el contexto teslaContext
		
		Assert.assertEquals(1856, teslaBirthYear);
		
		log.info("teslaBirthYear: {}", teslaBirthYear);
		
		// -------------------------------------

		String teslaNationality = null; // definir y obtener el valor de la expresion "nationality" en el contexto teslaContext
		
		Assert.assertEquals("Serbian", teslaNationality);
		
		log.info("teslaNationality: {}", teslaNationality);
		
		// -------------------------------------
		
		PlaceOfBirth teslaPlaceOfBirth = null; // ???
		
		Assert.assertNotNull(teslaPlaceOfBirth);
		
		Assert.assertThat("Serbia", CoreMatchers.is(teslaPlaceOfBirth.getCountry()));
		
		log.info("teslaPlaceOfBirth: {}", teslaPlaceOfBirth);

	}

	@Test
	public void arraysSpelTest() {

		log.info("arraysSpelTest -------------------");

		String invention_2 = null; // definir expresión que corresponda con obtener el valor del invento posición 2 de Tesla
		
		Assert.assertEquals("the transmission of electrical power", invention_2);
		
		log.info("invention_2: {}", invention_2);

	}

	@Test
	public void listSpelTest() {

		log.info("listSpelTest -------------------");

		Inventor teslaInventor = null; // definir expresión que corresponda con obtener el valor del miembro posición 2 del contexto society
		
		Assert.assertNotNull(teslaInventor);
		
		Assert.assertEquals("Nikola Tesla", teslaInventor.getName());
		
		log.info("teslaInventor: {}", teslaInventor);
		
		// -------------------------------------

		String teslaName = null; // utilizando el contexto society, obtener el nombre de Tesla
		
		Assert.assertNotNull(teslaName);
		
		Assert.assertEquals("Nikola Tesla", teslaName);
		
		log.info("teslaName: {}", teslaName);
		
		// -------------------------------------

		String inventionName_1 = null; // utilizando el contexto society, obtener el nombre del invento posición 1 del miembro posición 2, obtener utilizando el nombre de la función
		
		Assert.assertNotNull(inventionName_1);
		
		Assert.assertEquals("high-voltage / high-frequency power experiments", inventionName_1);
		
		log.info("inventionName_1: {}", inventionName_1);
		
		// -------------------------------------

		String otherInventionName_1 = null; // utilizando el contexto society, obtener el nombre del invento posición 1 del miembro posición 2, obener utilizando posición en el arreglo
				
		Assert.assertNotNull(otherInventionName_1);
		
		Assert.assertEquals("high-voltage / high-frequency power experiments", otherInventionName_1);
		
		log.info("otherInventionName_1: {}", otherInventionName_1);

		// -------------------------------------

		Assert.assertEquals(inventionName_1, otherInventionName_1);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void inlineListSpelTest() {

		log.info("inlineListSpelTest -------------------");

		List<Integer> listOfIntegers = null; // definir y obtener el valor de una expresión que corresponda a la definición de una lista de enteros del 1 al 4
		
		Assert.assertNotNull(listOfIntegers);

		Integer sum = listOfIntegers.stream().reduce(0, (i, j) -> i + j);
		
		Integer sumExpected = 10;

		Assert.assertEquals(sumExpected, sum);
		
		log.info("listOfIntegers: {}", listOfIntegers);
		
		// -------------------------------------

		List<List<String>> listOfListOfStrings = null; // definir y obtener el valor de una expresión que corresponda a la definición de una lista de listas de strings
		
		Assert.assertNotNull(listOfListOfStrings);

		log.info("listOfListOfStrings: {}", listOfListOfStrings);
	}

	@Test
	public void mapSpelTest() {

		log.info("mapSpelTest -------------------");

		Inventor president = null; // definir y obtener el inventor 'presidente' del mapa 'oficiales' del contexto society
		
		Assert.assertEquals("Mihajlo Idvorski Pupin", president.getName());
		
		log.info("president: {}", president);
		
		// -------------------------------------

		String presidentBornCity = null; // definir y obtener el nombre de la ciudad de nacimiento del inventor 'presidente' del mapa 'oficiales' del contexto society
		
		Assert.assertEquals("Village of Idvor", presidentBornCity);
		
		log.info("presidentBornCity: {}", presidentBornCity);

		// -------------------------------------

		// setter
		// definir y asignar el valor 'Croacia' como nueva ciudad de nacimiento el inventor 'presidente' del mapa 'oficiales' del contexto society

		String newPresidentBornCity = null; // definir y obtener el nombre de la ciudad de nacimiento del inventor 'presidente' del mapa 'oficiales' del contexto society
		
		Assert.assertEquals("Croacia", newPresidentBornCity);
		
		log.info("newPresidentBornCity: {}", newPresidentBornCity);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void inlineMapSpelTest() {

		log.info("inlineMapSpelTest -------------------");

		Map<String, String> mapOfValues = (Map<String, String>) spelParser
				.parseExpression("{name:'Nikola Tesla', bornDate: '09/07/1856'}").getValue(); // sólo analizar
		
		Assert.assertNotNull(mapOfValues);
		
		for (String key : mapOfValues.keySet()) {
			log.info("{}: {}", key, mapOfValues.get(key));
		}
		
		log.info("mapOfValues: {}", mapOfValues);
		
		// -------------------------------------

		String nikolaName = (String) spelParser.parseExpression("['name']").getValue(mapOfValues); // sólo analizar
		
		Assert.assertNotNull(nikolaName);
		
		Assert.assertEquals("Nikola Tesla", nikolaName);
		
		log.info("nikolaName: {}", nikolaName);
	}

	@Test
	public void arrayConstructionSpelTest() {

		log.info("arrayConstructionSpelTest -------------------");

		int[] emptyIntArray = (int[]) spelParser.parseExpression("new int[4]").getValue(); // sólo analizar
		
		Assert.assertNotNull(emptyIntArray);
		
		Assert.assertArrayEquals(new int[4], emptyIntArray);
		
		log.info("emptyIntArray: {}", emptyIntArray);

		// -------------------------------------

		int[] intArray = (int[]) spelParser.parseExpression("new int[]{1,2,3,4,5}").getValue(); // sólo analizar
		
		Assert.assertNotNull(intArray);
		
		Assert.assertThat(15, CoreMatchers.is(IntStream.of(intArray).reduce(0, (i, j) -> i + j)));
		
		log.info("intArray: {}", intArray);
	}
}
