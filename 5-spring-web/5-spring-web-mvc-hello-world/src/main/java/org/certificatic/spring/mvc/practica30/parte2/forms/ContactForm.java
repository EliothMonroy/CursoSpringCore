package org.certificatic.spring.mvc.practica30.parte2.forms;

import java.util.List;

import lombok.Data;

@Data
public class ContactForm {
	private String name;
	private String email;
	private String gender;
	private String password;
	private String confirmPassword;
	private List<String> courses;
	private String tutor;
	private String hiddenMessage;
}
