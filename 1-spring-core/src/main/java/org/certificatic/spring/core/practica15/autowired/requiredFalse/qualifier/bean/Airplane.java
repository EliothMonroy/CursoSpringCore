package org.certificatic.spring.core.practica15.autowired.requiredFalse.qualifier.bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Airplane {

	// Inyeccion no requerida
	private @Setter(AccessLevel.NONE) String airplaneCode;

	// Inyeccion requerida
	// Inyectar un Airline especifica
	private @Setter(AccessLevel.NONE) Airline airline;

}
