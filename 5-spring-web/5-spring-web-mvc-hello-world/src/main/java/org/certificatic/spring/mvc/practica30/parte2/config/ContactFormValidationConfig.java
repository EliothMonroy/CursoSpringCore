package org.certificatic.spring.mvc.practica30.parte2.config;

import org.certificatic.spring.mvc.practica30.parte2.validator.ContactFormValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

@Configuration
@ComponentScan("org.certificatic.spring.mvc.practica29.parte2.controller")
public class ContactFormValidationConfig {

	@Bean
	public Validator contactFormValidator() {
		return new ContactFormValidator();
	}

}
