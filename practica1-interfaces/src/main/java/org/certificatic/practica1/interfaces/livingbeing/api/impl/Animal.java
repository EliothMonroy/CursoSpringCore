package org.certificatic.practica1.interfaces.livingbeing.api.impl;

import org.certificatic.practica1.interfaces.livingbeing.api.LivingBeing;

import lombok.Data;

@Data
public abstract class Animal implements LivingBeing {
	private String type = "Animal";
	private String subType;
}
