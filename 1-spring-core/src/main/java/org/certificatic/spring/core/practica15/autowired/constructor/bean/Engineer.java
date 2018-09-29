package org.certificatic.spring.core.practica15.autowired.constructor.bean;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Engineer {

	private @Setter(AccessLevel.NONE) String name;
	private @Setter(AccessLevel.NONE) Integer age;
	private String dni;
	private @Setter(AccessLevel.NONE) Laptop laptop;
	private @Setter(AccessLevel.NONE) Stylus stylus;

	// Inyectar
	@Autowired
	public Engineer(String name, Integer age, Laptop laptop, Stylus stylus) {
		super();
		this.name = name;
		this.age = age;
		this.laptop = laptop;
		this.stylus = stylus;
	}

}
