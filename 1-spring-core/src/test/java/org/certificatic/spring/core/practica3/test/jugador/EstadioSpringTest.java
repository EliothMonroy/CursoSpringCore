package org.certificatic.spring.core.practica3.test.jugador;

import org.certificatic.spring.core.practica3.jugador.JugadorFutbol;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EstadioSpringTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica3/jugador-application-context.xml");
	}

	@Test
	public void estadioSpringTest1() {

		log.info("estadioSpringTest1 -------------------");

		// Implementar
		JugadorFutbol jugador = applicationContext.getBean("jugador", JugadorFutbol.class);

		Assert.assertNotNull(jugador);
		Assert.assertNotNull(jugador.getPartido());
		Assert.assertNotNull(jugador.getTorneo());
		Assert.assertNotNull(jugador.getTorneo().getEvento());

		jugador.saludar();
	}

	@Test
	public void estadioSpringTest2() {
		log.info("estadioSpringTest2 -------------------");

		//Implementar
	}

}
