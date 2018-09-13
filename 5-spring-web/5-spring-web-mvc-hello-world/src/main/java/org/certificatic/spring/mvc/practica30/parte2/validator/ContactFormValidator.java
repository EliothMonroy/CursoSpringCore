package org.certificatic.spring.mvc.practica30.parte2.validator;

import org.certificatic.spring.mvc.practica30.parte2.forms.ContactForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContactFormValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ContactForm.class);
	}

	public void validate(Object obj, Errors errors) {
		ContactForm contactForm = (ContactForm) obj;

		// Implementar validador
	}
}