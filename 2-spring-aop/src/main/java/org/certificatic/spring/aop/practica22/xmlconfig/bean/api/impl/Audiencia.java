package org.certificatic.spring.aop.practica22.xmlconfig.bean.api.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.certificatic.spring.aop.practica22.xmlconfig.bean.api.IAudiencia;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Bean Audiencia
public class Audiencia implements IAudiencia {

	// Inyecta IColorWriter
	private IColorWriter colorWriter;

	@Override
	public void aplaudir() {
		print(colorWriter.getColoredMessage(Color.BLUE,
				"[Aspecto Audiencia] El p�blico aplaude... clap, clap, clap...."));
	}

	@Override
	public void abuchear() {
		print(colorWriter.getColoredMessage(Color.RED,
				"[Aspecto Audiencia] El p�blico abuchea... buuuuuuuuuuuu...."));
	}

	@Override
	public void sePoneDePie() {
		print(colorWriter.getColoredMessage(Color.YELLOW,
				"[Aspecto Audiencia] El p�blico se pone de pie."));
	}

	@Override
	public void seSienta() {
		print(colorWriter.getColoredMessage(Color.YELLOW,
				"[Aspecto Audiencia] El p�blico se sienta en su lugar."));
	}

	@Override
	public void gritaGol() {
		print(colorWriter.getColoredMessage(Color.GREEN,
				"[Aspecto Audiencia] El p�blico grita gol... GOOOOOOOOOOOOOOOOOOOOOOOOL !!!!"));
	}

	@Override
	public void gritaOle() {
		print(colorWriter.getColoredMessage(Color.MAGENTA,
				"[Aspecto Audiencia] El p�blico grita Ole... Ooooooleeeeeee..."));
	}

	private void print(String mensaje) {
		log.info("{}", mensaje);
	}

	@Override
	public Object sePoneDeNervios(ProceedingJoinPoint pjp) throws Throwable {

		print(colorWriter.getColoredMessage(Color.CYAN,
				"[Aspecto Audiencia] El p�blico se pone de nervios"));

		Object o = null;

		// Implementa m�todo "se pone de nervios"

		print(colorWriter.getColoredMessage(Color.CYAN,
				"[Aspecto Audiencia] El p�blico se deja de pone de nervios"));

		return o;
	}

}
