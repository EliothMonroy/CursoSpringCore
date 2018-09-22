package org.certificatic.spring.core.practica5.test.scopes;

import org.certificatic.spring.core.practica5.scopes.bean.Persona;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScopesSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica5/scopes-application-context.xml");
	}

	@Test
	public void scopeSingletonSpringTest() {

		log.info("scopeSingletonSpringTest -------------------");

		// Implementar
		for (int i = 0; i < 5; i++) {
			Persona persona = applicationContext.getBean("personaSingletonBean", Persona.class);

			Assert.assertNotNull(persona);
			log.info("persona: {} {} {}", persona, persona.hashCode(),
					System.identityHashCode(persona));
		}
	}

	@Test
	public void scopePrototypeSpringTest() {

		log.info("scopePrototypeSpringTest -------------------");

		// Implementar
		for (int i = 0; i < 5; i++) {
			Persona persona = applicationContext.getBean("personaPrototypeBean", Persona.class);

			Assert.assertNotNull(persona);
			log.info("persona: {} {} {}", persona, persona.hashCode(),
					System.identityHashCode(persona));
		}

	}
}
