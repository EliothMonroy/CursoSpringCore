package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest2 {

	@Test
	public void holaMundoSpringTest2() {
		log.info("holaMundoSpringTest2 -------------------------");

		String ruta = "spring/practica2/beans.xml";

		// Implementar IoC con ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext(ruta);

		HolaMundo holaMundo1 = (HolaMundo) ctx.getBean("holaMundoBean");

		HolaMundo holaMundo2 = (HolaMundo) ctx.getBean("holaMundoBean");

		Assert.assertNotNull(holaMundo1);
		Assert.assertNotNull(holaMundo1.getMensaje());

		Assert.assertNotNull(holaMundo2);
		Assert.assertNotNull(holaMundo2.getMensaje());

		Assert.assertEquals(holaMundo1, holaMundo2);
		Assert.assertSame(holaMundo1, holaMundo2);

		log.info("hola mundo 1: {}", holaMundo1);

		log.info("hola mundo 2: {}", holaMundo2);

	}
	

}
