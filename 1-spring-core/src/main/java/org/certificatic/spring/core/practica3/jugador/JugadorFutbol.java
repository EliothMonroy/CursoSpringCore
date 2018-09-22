package org.certificatic.spring.core.practica3.jugador;

import org.certificatic.spring.core.practica3.liga.Partido;
import org.certificatic.spring.core.practica3.liga.Torneo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class JugadorFutbol {

	private @Setter(AccessLevel.NONE) Torneo torneo;
	private @Setter(AccessLevel.NONE) Partido partido;
	private @Setter(AccessLevel.NONE) String nombre;

	public void saludar() {
		System.out.println("hola soy un jugador de Futbol");
		System.out.println("me llamo: " + this.nombre + " ["
				+ Integer.toHexString(super.hashCode()) + "]");
	}
}
