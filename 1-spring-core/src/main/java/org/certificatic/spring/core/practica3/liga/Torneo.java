package org.certificatic.spring.core.practica3.liga;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Torneo {

	private @Setter(AccessLevel.NONE) Evento evento;
	private @Setter(AccessLevel.NONE) String nombre;
}
