package org.certificatic.spring.core.practica12.collections.bean;

import lombok.Data;

@Data
public class Phone {
	private String number;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}
}
