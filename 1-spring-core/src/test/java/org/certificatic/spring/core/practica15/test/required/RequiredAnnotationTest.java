package org.certificatic.spring.core.practica15.test.required;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequiredAnnotationTest {

	@Test
	public void requiredAnnotationTest() {

		log.info("requiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
	}

	@Test(expected = BeanCreationException.class)
	public void badRequiredAnnotationTest() {

		log.info("badRequiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
	}

}
