package org.certificatic.spring.core.practica8.factorymethod.bean;

import lombok.Data;

@Data
public class Student {
	private String name;
	private Subject subject;

	private Student() {
	}

	public static Student constructStudent(String name, String materia) {
		Student a = new Student();
		a.setName(name);
		a.setSubject(new Subject());
		a.getSubject().setName(materia);
		a.getSubject().setTeacher(new Teacher());
		a.getSubject().getTeacher().setName("Ivan");
		return a;
	}

}
