package org.certificatic.spring.core.practica7.lazyinit.bean;

import lombok.Data;

@Data
public class Wheel {
	private int rinSize;
	private String brand;
	private String material;

	public Wheel() {
		System.out.println("Constructing Wheel()");
	}
}
