package org.certificatic.spring.core.practica7.lazyinit.bean;

import lombok.Data;

@Data
public class Car {
	private Engine engine;
	private Wheel wheel1;
	private Wheel wheel2;
	private Wheel wheel3;
	private Wheel wheel4;

	public Car() {
		System.out.println("Constructing Car()");
	}
}
