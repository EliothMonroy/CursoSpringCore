package org.certificatic.spring.core.practica14.numericalConverter.bean;

import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

public class NumericalConverter {

	private @Getter @Setter Numerical numerical;
	private @Getter @Setter Currency currrency;

	public NumericalConverter() {
	}

	public NumericalConverter(Numerical numerical) {
		this.numerical = numerical;
	}

	public String convert(String number, boolean capitalLetters) {
		String literal = "";
		String decimalPart;
		String letterNumber = null;

		// Si utiliza '.', reemplazamos por ','
		number = number.replace(".", ",");

		// Si el numero no tiene parte decimal, le agregamos ',00'
		if (number.indexOf(",") == -1) {
			number += ",00";
		}

		int indice = 0;
		for (int i = 0; i < number.indexOf(","); i++) {
			if (number.charAt(i) != '0') {
				indice = i;
				break;
			}
		}
		number = number.substring(indice);

		// Validar el formato de entrada: desde 0,00 hasta 999999999,00
		if (Pattern.matches("\\d{1,9},\\d{1,2}", number)) {

			// Se separa parte entera y parte decimal
			String num[] = number.split(",");

			// Se formatea parte decimal
			decimalPart = num[1] + "/100";

			// Se convierte el numero a literal.
			if (Integer.parseInt(num[0]) == 0) { // Si es cero
				literal = numerical.getZero();

			} else if (Integer.parseInt(num[0]) > 999999) { // Si son millones
															// 1000000 -
															// 999999999
				literal = getMillions(num[0]);

			} else if (Integer.parseInt(num[0]) > 999) { // Si son miles 1000 -
															// 999999
				literal = getThousands(num[0]);

			} else if (Integer.parseInt(num[0]) > 99) { // Si son cientos 100 -
														// 999
				literal = getHundreds(num[0]);

			} else if (Integer.parseInt(num[0]) > 9) { // Si son decenas 10 - 99
				literal = getDozens(num[0]);

			} else { // Si son unidades: 1 - 9
				literal = getUnits(num[0]);

			}

			if (Integer.parseInt(num[0]) == 1) {
				letterNumber = literal + " " + currrency.getSingularCurrency() + " "
						+ decimalPart;
			} else {
				letterNumber = literal + " " + currrency.getPluralCurrency() + " "
						+ decimalPart;
			}

			if (capitalLetters)
				letterNumber = letterNumber.toUpperCase();
			else
				letterNumber = letterNumber.toLowerCase();
		}

		return letterNumber;
	}

	private String getMillions(String number) { // 1000000 - 999999999

		String thousands = number.substring(number.length() - 6);

		String millions = number.substring(0, number.length() - 6); // 000252

		// verificar que millones sea diferente de cero
		if (Integer.parseInt(millions) > 0) {

			String temp = "";
			if (Integer.parseInt(millions) > 1) {
				temp = getHundreds(millions) + " " + numerical.getMillions();
			} else {
				temp = getHundreds(millions) + " " + numerical.getOneMillion();
			}

			return temp + " " + getThousands(thousands);

		} else {
			return getThousands(thousands);
		}

	}

	private String getThousands(String number) { // 1000 - 999999

		String hundreds = number.substring(number.length() - 3);

		String thousands = number.substring(0, number.length() - 3); // 000252

		// verificar que miles sea diferente de cero
		if (Integer.parseInt(thousands) > 0) {
			return getHundreds(thousands) + " " + numerical.getOneThousand() + " "
					+ getHundreds(hundreds);
		} else {
			return getHundreds(hundreds);
		}
	}

	private String getHundreds(String number) { // 100 - 999
		int num = Integer.parseInt(number);

		if (num > 99) { // Son centenas
			if (num == 100) {
				return numerical.getOneHundred();
			} else {
				return numerical.getHundreds()[Integer.parseInt(number.substring(
						0, 1))] + " " + getDozens(number.substring(1));
			}

		} else { // 099
			return getDozens(num + "");
		}
	}

	private String getDozens(String number) { // 10 - 99
		int num = Integer.parseInt(number);

		if (num < 10) { // 01 - 09
			return getUnits(number);

		} else if (num > 19) { // 20 - 99
			String u = getUnits(number);

			if (u.equals("")) { // 20, 30, 40 ... 90
				return numerical.getDozens()[Integer.parseInt(number.substring(
						0, 1)) + 8];

			} else { // Devolvio un numero que no es 20, 30, 40 ... 90
				return numerical.getDozens()[Integer.parseInt(number.substring(
						0, 1)) + 8] + " " + numerical.getAnd() + " " + u;
			}

		} else { // numeros del 10 - 19
			return numerical.getDozens()[num - 10];
		}
	}

	private String getUnits(String number) { // 1 - 9, se puede recibir
												// como 00005
		String num = number.substring(number.length() - 1);

		return numerical.getUnits()[Integer.parseInt(num)];
	}
}
