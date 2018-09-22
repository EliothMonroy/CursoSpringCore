package org.certificatic.spring.core.practica3.liga;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Evento {

	private @Setter(AccessLevel.NONE) String nombre;
}
