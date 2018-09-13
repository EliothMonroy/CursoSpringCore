package org.certificatic.spring.core.practica14.numericalConverter.bean;

public class Numerical {

	private final String[] UNITS = { "", "un", "dos", "tres", "cuatro", "cinco",
			"seis", "siete", "ocho", "nueve" };

	private final String[] DOZENS = { "diez", "once", "doce", "trece",
			"catorce", "quince", "dieciseis", "diecisiete", "dieciocho",
			"diecinueve", "veinte", "treina", "cuarenta", "cincuenta",
			"sesenta", "setenta", "ochenta", "noventa" };

	private final String[] HUNDREDS = { "", "ciento", "doscientos",
			"trescientos", "cuatrocientos", "quinientos", "seiscientos",
			"setecientos", "ochocientos", "novecientos" };

	public String[] getUnits() {
		return UNITS;
	}

	public String[] getDozens() {
		return DOZENS;
	}

	public String[] getHundreds() {
		return HUNDREDS;
	}

	public String getZero() {
		return "cero";
	}

	public String getOneHundred() {
		return "cien";
	}

	public String getAnd() {
		return "y";
	}

	public String getOneThousand() {
		return "mil";
	}

	public String getOneMillion() {
		return "millon";
	}

	public String getMillions() {
		return "millones";
	}

}
