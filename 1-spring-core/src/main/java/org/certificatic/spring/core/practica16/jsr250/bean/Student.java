package org.certificatic.spring.core.practica16.jsr250.bean;

import lombok.Data;

@Data
public class Student {

	// Inyeactar
	private String name;

	// Inyeactar
	private String enrollment;

	// Inyeactar
	private Subject subject;

	// Inyeactar a mathematics subject

	// Inicializar
	public void postConstructCallback() {
		System.out.println("Initializing Student Bean");
	}

	// Destruir
	public void preDestroyCallback() {
		System.out.println("Destroying Student Bean");
	}

}
