package org.certificatic.spring.core.practica5.test.scopes;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScopesSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
	}

	@Test
	public void scopeSingletonSpringTest() {

		log.info("scopeSingletonSpringTest -------------------");

		// Implementar
	}

	@Test
	public void scopePrototypeSpringTest() {

		log.info("scopePrototypeSpringTest -------------------");

		// Implementar

	}
}
