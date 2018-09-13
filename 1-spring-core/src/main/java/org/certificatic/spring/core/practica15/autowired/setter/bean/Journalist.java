package org.certificatic.spring.core.practica15.autowired.setter.bean;

import lombok.Data;

@Data
public class Journalist {
	private String name;
	private Integer age;
	private String dni;

	private NoteBook notebook;
	private Pen pen;

	// Inyectar
	public void setName(String name) {
		this.name = name;
	}

	// Inyectar
	public void setAge(Integer age) {
		this.age = age;
	}

	// Inyectar
	public void setNotebook(NoteBook notebook) {
		this.notebook = notebook;
	}

	// Inyectar
	public void setAge(Pen pen) {
		this.pen = pen;
	}

}
