package org.certificatic.spring.soba.dao.hibernate.validation.api.impl;

import java.util.List;

import org.certificatic.spring.soba.dao.hibernate.exceptions.ValidationError;
import org.certificatic.spring.soba.dao.hibernate.validation.api.ICustomValidator;
import org.certificatic.spring.soba.dao.hibernate.validation.api.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ValidatorImpl implements IValidator {

	@Autowired
	private ICustomValidator customValidator;

	public boolean supports(final Class<?> clazz) {
		return true;
	}

	public void validate(final Object target, final Errors errors) {
		customValidator.isValid(errors, target, null);
	}

	public void validate(final Object target, final Errors errors, List<ValidationError> listValidationError,
			final Class<?>... validatorGroups) {
		customValidator.isValid(errors, target, listValidationError, validatorGroups);
	}

	public void validate(Object target, Errors errors, List<ValidationError> listValidationError) {
		customValidator.isValid(errors, target, listValidationError);
	}

}
