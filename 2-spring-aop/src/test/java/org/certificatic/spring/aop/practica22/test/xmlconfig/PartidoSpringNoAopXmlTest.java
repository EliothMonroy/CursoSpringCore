package org.certificatic.spring.aop.practica22.test.xmlconfig;

import org.certificatic.spring.aop.practica22.xmlconfig.bean.api.IAudiencia;
import org.certificatic.spring.aop.practica22.xmlconfig.bean.api.IJugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "classpath:/spring/practica22/partido-sin-aop-application-context.xml")
public class PartidoSpringNoAopXmlTest {

	@Value("#{jugadorBean}")
	private IJugador jugador;

	@Value("#{audienciaBean}")
	private IAudiencia audiencia;

	@Before
	public void setUp() {
		Assert.assertNotNull(jugador);
		Assert.assertNotNull(audiencia);
	}

	@Test
	public void partidoNoSpringAopXMLTest() {

		log.info("partidoNoSpringAopXMLTest -------------------");

		audiencia.gritaOle();
		jugador.ejecutarPase();
		audiencia.gritaOle();

		log.info("------------");

		audiencia.gritaOle();
		jugador.ejecutarPase();
		audiencia.gritaOle();

		log.info("------------");

		audiencia.sePoneDePie();
		try {
			jugador.cobrarPenal(true);

			audiencia.gritaGol();

		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());

			audiencia.abuchear();
			audiencia.abuchear();
		}
		audiencia.seSienta();

		log.info("------------");

		audiencia.sePoneDePie();
		try {
			jugador.cobrarPenal(false);

			audiencia.gritaGol();

		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());

			audiencia.abuchear();
			audiencia.abuchear();
		}
		audiencia.seSienta();

		log.info("------------");

		jugador.cometerFalta();
		audiencia.abuchear();

		log.info("------------");

		try {
			jugador.tirarAGol(false);

			audiencia.gritaGol();
			audiencia.gritaGol();
			audiencia.aplaudir();
			audiencia.aplaudir();

		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());
		}

		log.info("------------");

		try {
			jugador.tirarAGol(true);

			audiencia.gritaGol();
			audiencia.gritaGol();
			audiencia.aplaudir();
			audiencia.aplaudir();

		} catch (Throwable e) {
			log.info("excepción: " + e.getMessage());
		}

		log.info("------------");

		jugador.esExpulsado();
		audiencia.abuchear();
		audiencia.abuchear();
		audiencia.aplaudir();
		audiencia.aplaudir();
	}

}
