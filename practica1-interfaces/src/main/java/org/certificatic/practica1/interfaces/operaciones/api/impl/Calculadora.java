package org.certificatic.practica1.interfaces.operaciones.api.impl;

import org.certificatic.practica1.interfaces.operaciones.api.Operaciones;

import lombok.Data;

@Data
public class Calculadora implements Operaciones {

	@Override
	public double suma() {
		return Operaciones.NUMERO1 + Operaciones.NUMERO2;
	}

	@Override
	public double resta() {
		return Operaciones.NUMERO1 - Operaciones.NUMERO2;
	}

	@Override
	public double multiplicacion() {
		return Operaciones.NUMERO1 * Operaciones.NUMERO2;
	}

	@Override
	public double division() {
		return Operaciones.NUMERO1 / Operaciones.NUMERO2;
	}

}