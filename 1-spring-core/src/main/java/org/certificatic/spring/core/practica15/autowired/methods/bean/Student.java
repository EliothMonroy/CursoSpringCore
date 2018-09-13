package org.certificatic.spring.core.practica15.autowired.methods.bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Student {

	private @Setter(AccessLevel.NONE) String name;
	private @Setter(AccessLevel.NONE) Integer age;
	private String dni;
	private @Setter(AccessLevel.NONE) StudentBook notebook;
	private @Setter(AccessLevel.NONE) PropellingPencil pen;

	public void initStudent(String name, Integer age, StudentBook notebook,
			PropellingPencil pen) {
		this.name = name;
		this.age = age;
		this.notebook = notebook;
		this.pen = pen;
	}

}
