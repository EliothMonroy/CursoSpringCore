package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest1 {

	@Test
	public void holaMundoNoSpringTest() {
		log.info("holaMundoNoSpringTest -------------------------");

		String ruta = "spring/practica2/beans.xml";

		// Implementar IoC con BeanFactory
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(ruta));

		HolaMundo holaMundo1 = (HolaMundo) beanFactory.getBean("holaMundoBean");

		HolaMundo holaMundo2 = (HolaMundo) beanFactory.getBean("holaMundoBean");

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
