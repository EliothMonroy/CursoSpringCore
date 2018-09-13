package org.certificatic.spring.core.practica16.test.jsr250;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Jsr250AnnotationTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica16/annotations-jsr250-application-context.xml");
	}

	@Test
	public void jsr250AnnotationTest() {

		log.info("jsr250AnnotationTest -------------------");

		// Implementar
	}

}
