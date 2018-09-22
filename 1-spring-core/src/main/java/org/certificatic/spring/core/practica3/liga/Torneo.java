package org.certificatic.spring.core.practica3.liga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Torneo {

	private @Setter Evento evento;
	private @Setter String nombre;
}
