package org.certificatic.spring.validation.practica30.parte1.validator.config;

import org.certificatic.spring.validation.practica30.parte1.validator.PersonValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;

@Configuration
public class ValidatorTestConfig {

	@Bean
	public Validator personValidator() {
		return new PersonValidator();
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}
}
