package org.certificatic.practica1.interfaces.livingbeing.api.impl;

import org.certificatic.practica1.interfaces.livingbeing.api.LivingBeing;

import lombok.Data;

@Data
public abstract class Plant implements LivingBeing {
	private String type = "Plant";
	private String subType;
}
