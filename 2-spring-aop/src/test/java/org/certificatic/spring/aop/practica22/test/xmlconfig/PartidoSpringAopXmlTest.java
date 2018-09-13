package org.certificatic.spring.aop.practica22.test.xmlconfig;

import org.certificatic.spring.aop.practica22.xmlconfig.bean.api.IJugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "classpath:/spring/practica22/partido-con-aop-application-context.xml")
public class PartidoSpringAopXmlTest {

	// Injecta Jugador Bean
	private IJugador jugador;

	@Before
	public void setUp() {
		Assert.assertNotNull(jugador);
	}

	@Test
	public void partidoNoSpringAopXMLTest() {

		log.info("partidoNoSpringAopXMLTest -------------------");

		jugador.ejecutarPase();

		log.info("------------");

		jugador.ejecutarPase();

		log.info("------------");

		try {
			jugador.cobrarPenal(true);
		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());

		}
		log.info("------------");

		try {
			jugador.cobrarPenal(false);
		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());
		}
		log.info("------------");

		jugador.cometerFalta();

		log.info("------------");

		try {
			jugador.tirarAGol(false);

		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());
		}
		log.info("------------");

		try {
			jugador.tirarAGol(true);
		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());
		}
		log.info("------------");

		jugador.esExpulsado();
	}

}
