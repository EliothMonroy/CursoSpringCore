package org.certificatic.spring.core.practica15.required.bean;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@Data
public class Cameraman {
	private String name;
	private Integer age;
	private String dni;

	@Required
	public void setName(String name) {
		this.name = name;
	}

	@Required
	public void setDni(String dni) {
		this.dni = dni;
	}

}
