package org.certificatic.spring.core.tarea2.test.namespaces.pcutil;

import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Agenda;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Circulo;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.MisProperties;
import org.certificatic.spring.core.tarea2.namespaces.pcutil.bean.Persona;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NamespacesPCUtilTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/tarea2/namespaces-p-c-util-application-context.xml");
	}

	@Test
	public void collectionsTest() {

		log.info("collectionsTest -------------------");

		Persona persona = applicationContext.getBean(Persona.class);

		Assert.assertNotNull(persona);

		log.info("persona: {}", persona);

		Circulo circulo = applicationContext.getBean(Circulo.class);

		Assert.assertNotNull(circulo);

		log.info("circulo: {}", circulo);

		Agenda agenda = applicationContext.getBean(Agenda.class);

		Assert.assertNotNull(agenda);

		log.info("agenda: {}", agenda);

		MisProperties misProperties = applicationContext.getBean(MisProperties.class);

		Assert.assertNotNull(misProperties);

		log.info("misProperties: {}", misProperties);

		((AbstractApplicationContext) applicationContext).close();
	}

}
