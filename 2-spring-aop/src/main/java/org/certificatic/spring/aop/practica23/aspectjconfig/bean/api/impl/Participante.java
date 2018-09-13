package org.certificatic.spring.aop.practica23.aspectjconfig.bean.api.impl;

import org.certificatic.spring.aop.practica23.aspectjconfig.bean.api.IVoluntario;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope("prototype")
public class Participante implements IVoluntario {

	@Autowired
	private IColorWriter colorWriter;

	private String pensamiento;

	@Override
	public void pensarEnAlgo(String pensamiento) {
		this.pensamiento = pensamiento;

		print(colorWriter.getColoredMessage(Color.MAGENTA,
				"[Participante] pienso en " + this.pensamiento
						+ "... [sssssh... es secreto.] "));

	}

	@Override
	public void pensarEnOtraCosa(String otroPensamiento) {
		this.pensamiento = otroPensamiento;

		print(colorWriter.getColoredMessage(Color.MAGENTA,
				"[Participante] pienso en " + this.pensamiento
						+ "... [sssssh... es secreto.] "));
	}

	@Override
	public String getPensamiento(boolean hacerTrampa) {
		return (!hacerTrampa) ? this.pensamiento : "Un vaso con agua.";
	}

	private void print(String mensaje) {
		log.info("{}", mensaje);
	}

}
