package org.certificatic.spring.core.practica8.factorymethod.bean;

public class StudentFactory {
	public Student buildStudent(String materia, String name) {
		return Student.constructStudent(name, materia);
	}
}
