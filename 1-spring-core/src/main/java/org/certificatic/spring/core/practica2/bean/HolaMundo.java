package org.certificatic.spring.core.practica2.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class HolaMundo {
	private @Getter @Setter String mensaje;

	public HolaMundo() {
	}

	public HolaMundo(String mensaje) {
		this.mensaje = mensaje;
	}
}
