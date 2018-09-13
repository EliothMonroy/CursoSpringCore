package org.certificatic.spring.core.practica12.collections.bean;

import lombok.Data;

@Data
public class Address {
	private String street;
	private int externalNumber;
	private Integer internalNumber;
	private String neighbor;

	public Address(String street, int externalNumber, Integer internalNumber) {
		this.street = street;
		this.externalNumber = externalNumber;
		this.internalNumber = internalNumber;
	}
}
