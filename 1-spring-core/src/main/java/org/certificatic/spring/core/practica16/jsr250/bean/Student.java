package org.certificatic.spring.core.practica16.jsr250.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import lombok.Data;

@Data
public class Student {

	// Inyectar
	@Resource
	private String name;

	// Inyectar
	@Resource
	private String enrollment;
	
	// Inyeactar
	@Resource
	private Subject mathematics;

	// Inyeactar
	@Resource(name="xyz")
	private Subject subject;

	// Inyeactar a mathematics subject

	// Inicializar
	@PostConstruct
	public void postConstructCallback() {
		System.out.println("Initializing Student Bean");
	}

	// Destruir
	@PreDestroy
	public void preDestroyCallback() {
		System.out.println("Destroying Student Bean");
	}

}
