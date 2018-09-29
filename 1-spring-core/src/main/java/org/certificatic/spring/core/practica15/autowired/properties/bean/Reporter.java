package org.certificatic.spring.core.practica15.autowired.properties.bean;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Reporter {

	// Inyectar
	@Autowired
	private @Setter(AccessLevel.NONE) String name;

	// Inyectar
	@Autowired
	private @Setter(AccessLevel.NONE) Integer age;

	private String dni;

	// Inyectar
	@Autowired
	private @Setter(AccessLevel.NONE) Booklet booklet;

	// Inyectar
	@Autowired
	private @Setter(AccessLevel.NONE) Pencil pencil;

}
