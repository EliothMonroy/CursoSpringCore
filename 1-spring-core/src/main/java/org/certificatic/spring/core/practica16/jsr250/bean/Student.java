package org.certificatic.spring.core.practica16.jsr250.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import lombok.Data;

@Data
public class Student {

	// Inyeactar
	@Resource
	private String name;

	// Inyeactar
	@Resource
	private String enrollment;

	// Inyeactar
	@Resource(name = "xyz")
	private Subject subject;

	// Inyeactar a mathematics subject
	@Resource
	private Subject mathematics;

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
