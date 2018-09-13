package org.certificatic.spring.soba.dao.hibernate.validation.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.certificatic.spring.soba.dao.hibernate.exceptions.ValidationError;
import org.certificatic.spring.soba.dao.hibernate.exceptions.ValidatorException;
import org.certificatic.spring.soba.dao.hibernate.validation.api.IValidator;
import org.certificatic.spring.soba.dao.hibernate.validation.api.IValidatorTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

@Component
public class ValidatorTemplate implements IValidatorTemplate {

	@Autowired
	private IValidator validator;

	@Override
	public void validate(final Object target, final Class<?>... validatorGroups) throws ValidatorException {
		final Map<String, String> map = new HashMap<String, String>();
		final BindingResult errors = new MapBindingResult(map, target.getClass().getSimpleName());

		final List<ValidationError> listValidationError = new ArrayList<>();

		validator.validate(target, errors, listValidationError, validatorGroups);

		verifyErrors(target, listValidationError);

	}

	@Override
	public void validate(final Object target, Errors errors, List<ValidationError> listValidationError,
			final Class<?>... validatorGroups)
			throws ValidatorException {
		final Map<String, String> map = new HashMap<String, String>();
		errors = new MapBindingResult(map, target.getClass().getSimpleName());

		listValidationError = new ArrayList<>();

		validator.validate(target, errors, listValidationError, validatorGroups);

		verifyErrors(target, listValidationError);
	}

	private void verifyErrors(final Object target, final List<ValidationError> listValidationError) {
		if (listValidationError.size() > 0) {

			final StringBuilder sb = new StringBuilder("[ValidatorTemplateImp] Error al validar objeto ");

			sb.append(target.getClass().getSimpleName()).append(" \n");

			for (int k = 0; k < listValidationError.size(); k++) {
				final ValidationError ve = listValidationError.get(k);

				sb.append(ve.getMessage());

				if (k < listValidationError.size() - 1) {
					sb.append("\n");
				}
			}
			throw new ValidatorException(sb.toString(), listValidationError);
		}
	}
}
