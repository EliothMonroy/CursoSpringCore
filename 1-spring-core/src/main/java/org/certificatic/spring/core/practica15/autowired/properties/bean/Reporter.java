package org.certificatic.spring.core.practica15.autowired.properties.bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Reporter {

	// Inyectar
	private @Setter(AccessLevel.NONE) String name;

	// Inyectar
	private @Setter(AccessLevel.NONE) Integer age;

	private String dni;

	// Inyectar
	private @Setter(AccessLevel.NONE) Booklet notebook;

	// Inyectar
	private @Setter(AccessLevel.NONE) Pencil pen;

}
