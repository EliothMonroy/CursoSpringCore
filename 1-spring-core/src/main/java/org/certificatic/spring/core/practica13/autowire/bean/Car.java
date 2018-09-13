package org.certificatic.spring.core.practica13.autowire.bean;

import lombok.Data;

@Data
public class Car {
	private Engine engine;
	private WheelGroup wheelGroup;

	public Car() {
	}

	public Car(Engine engine, WheelGroup wheelGroup) {
		super();
		this.engine = engine;
		this.wheelGroup = wheelGroup;
	}

	@Override
	public String toString() {
		String string = "\nCar [\n" + "\tengine: " + engine + "\n"
				+ "\twheelGroup: " + wheelGroup + "\n" + "]";

		return string;
	}
}