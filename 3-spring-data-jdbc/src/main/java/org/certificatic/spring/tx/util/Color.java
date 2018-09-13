package org.certificatic.spring.tx.util;

public enum Color {
	BLACK("black"), BLUE("blue"), CYAN("cyan"), DEFAULT("default"), GREEN(
			"green"), MAGENTA("magenta"), RED("red"), WHITE("white"), YELLOW(
					"yellow");

	private String color;

	private Color(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}
}
