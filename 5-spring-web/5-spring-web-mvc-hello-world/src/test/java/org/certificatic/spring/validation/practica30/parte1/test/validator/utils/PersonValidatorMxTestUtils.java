package org.certificatic.spring.validation.practica30.parte1.test.validator.utils;

import java.util.Locale;

import org.junit.Assert;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonValidatorMxTestUtils {

	public static void printErrors(BindException errors, MessageSource messageSource, Locale mxLocale) {

		log.info("Errors {}", errors.getErrorCount());

		for (ObjectError error : errors.getAllErrors()) {

			FieldError fieldError = (FieldError) error;

			if (fieldError.getField().equals("name")) {

				Assert.assertEquals("Name is required.", messageSource.getMessage(error, mxLocale));

			} else if (fieldError.getField().equals("age")) {

				if (fieldError.getRejectedValue() != null && ((Integer) fieldError.getRejectedValue()) < 18)
					Assert.assertEquals("Edad necesita ser mayor o igual a 18 para el objeto Persona.", messageSource
							.getMessage(error,
									mxLocale));
				else
					Assert.assertEquals("Edad es requerido para el objeto Persona.", messageSource.getMessage(error,
							mxLocale));
			}

			log.info("{}: {}", fieldError.getField(), messageSource.getMessage(error, mxLocale));
		}
	}

}
