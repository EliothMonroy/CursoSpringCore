package org.certificatic.spring.core.practica15.required.bean;

import lombok.Data;

@Data
public class Cameraman {
	private String name;
	private Integer age;
	private String dni;

	public void setName(String name) {
		this.name = name;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
