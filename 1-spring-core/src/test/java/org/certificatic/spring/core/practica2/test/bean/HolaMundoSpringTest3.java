package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest3 {

	private static ApplicationContext factory;

	// Instanciar ApplicationContext Antes de ejecutar la clase de test
	@BeforeClass
	public static void setUp() {
		String ruta = "spring/practica2/beans.xml";
		factory = new ClassPathXmlApplicationContext(ruta);
	}

	@AfterClass
	public static void close() {
		((ConfigurableApplicationContext) factory).close();
	}

	@Test
	public void holaMundoSpringTest2() {
		log.info("holaMundoSpringTest2 -------------------------");

		// Implementar IoC con ApplicationContext
		HolaMundo holaMundo1 = (HolaMundo) factory.getBean("holaMundoBean");

		Assert.assertNotNull(holaMundo1);
		Assert.assertNotNull(holaMundo1.getMensaje());

		log.info("hola mundo 1: {}", holaMundo1);
	}

	@Test
	public void holaMundoSpringTest3() {
		log.info("holaMundoSpringTest2 -------------------------");

		// Implementar IoC con ApplicationContext
		HolaMundo holaMundo1 = (HolaMundo) factory.getBean("holaMundoBean");

		Assert.assertNotNull(holaMundo1);
		Assert.assertNotNull(holaMundo1.getMensaje());

		log.info("hola mundo 1: {}", holaMundo1);

	}
}
