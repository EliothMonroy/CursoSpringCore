package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoNoSpringTest {

	@Test
	public void holaMundoNoSpringTest() {
		log.info("holaMundoNoSpringTest -------------------------");

		// Crear instancia de HolaMundo
		
		HolaMundo mundo = new HolaMundo("Hola curso spring");
		//mundo.setMensaje("Hola mundo");
		
		Assert.assertNotNull(mundo);
		Assert.assertNotNull(mundo.getMensaje());
		
		log.info("mundo: {}", mundo);

	}
}
