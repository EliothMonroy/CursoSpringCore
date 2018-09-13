package org.certificatic.spring.core.tarea2.namespaces.pcutil.bean;

import lombok.Data;

@Data
public class Circulo {
	private Double pi;
	private Double radio;

	public Double getArea() {
		return pi * radio * radio;
	}
}
