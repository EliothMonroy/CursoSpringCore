package org.certificatic.practica1.interfaces.operaciones.test;

import java.text.DecimalFormat;

import org.certificatic.practica1.interfaces.operaciones.api.Operaciones;
import org.certificatic.practica1.interfaces.operaciones.api.impl.Calculadora;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperacionesTest {
	private DecimalFormat df = new DecimalFormat("#.####");

	@Test
	public void operacionesTest() {
		log.info("operacionesTest -------------------");

		Operaciones operaciones = new Calculadora();

		log.info("operaciones: {}", operaciones);

		log.info("operaciones.suma() = {}", df.format(operaciones.suma()));
		log.info("operaciones.resta() = {}", df.format(operaciones.resta()));
		log.info("operaciones.multiplicacion() = {}", df.format(operaciones.multiplicacion()));
		log.info("operaciones.division() = {}", df.format(operaciones.division()));

	}
}
