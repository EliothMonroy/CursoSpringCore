package org.certificatic.spring.core.utils;

public class StringUtils {

	public static String reverseString(String input) {
		StringBuilder backwards = new StringBuilder();
		for (int i = 0; i < input.length(); i++)
			backwards.append(input.charAt(input.length() - 1 - i));
		return backwards.toString();
	}
}
