package org.certificatic.spring.core.practica14.test.numericalConverter;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericalConverterTest {

	private static ClassPathXmlApplicationContext applicationContext;

	private DecimalFormat currencyFormat = new DecimalFormat(
			"$ ###,###,###.##");
	private DecimalFormat simpleNumberFormat = new DecimalFormat("#.##");

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica14/numerical-converter-application-context.xml");
	}

	@Test
	public void numericalConverterTest() {

		log.info("numericalConverterTest -------------------");

		// Obtener bean NumericalConverter
		// realizar test con Asserts

		((AbstractApplicationContext) applicationContext).close();
	}

}
