package org.certificatic.spring.core.practica7.lazyinit.bean;

import lombok.Data;

@Data
public class Engine {
	private String serial;
	private int cylinderNumber;
	private int hp;

	public Engine() {
		System.out.println("Constructing Engine()");
	}
}
