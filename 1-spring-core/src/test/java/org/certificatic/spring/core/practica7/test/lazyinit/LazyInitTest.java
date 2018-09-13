package org.certificatic.spring.core.practica7.test.lazyinit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyInitTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
	}

	@Test
	public void lazyInitTest() {

		log.info("lazyInitTest -------------------");

		// Implementar
	}

}
