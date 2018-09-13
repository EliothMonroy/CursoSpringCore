package org.certificatic.spring.soba.dao.hibernate.validation.api.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.certificatic.spring.soba.dao.hibernate.exceptions.ValidationError;
import org.certificatic.spring.soba.dao.hibernate.validation.api.ICustomValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomValidatorImpl implements ICustomValidator {

	@Override
	public boolean isValid(final Errors errors, final Object objeto, List<ValidationError> listValidationError,
			Class<?>... validatorGroups) {
		if (validatorGroups == null || validatorGroups.length == 0 || validatorGroups[0] == null) {
			validatorGroups = new Class<?>[] { Default.class };
		}

		printValidatorGroups(validatorGroups);
		final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		final Set<ConstraintViolation<Object>> violations = validator.validate(objeto, validatorGroups);

		for (final ConstraintViolation<Object> v : violations) {
			final Path path = v.getPropertyPath();
			String propertyName = "";
			if (path != null) {
				for (final Node n : path) {
					propertyName += n.getName() + ".";
				}
				propertyName = propertyName.substring(0, propertyName.length() - 1);
			}

			final String constraintName = v.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();

			final ValidationError ve = new ValidationError("VALIDATION-ERROR", v.getMessage(), objeto,
					propertyName, constraintName, v.getInvalidValue());
			// ve.setAtributo(propertyName);
			// ve.setCodigo(constraintName);
			// ve.setObjeto(objeto.getClass().getSimpleName());
			// ve.setValorRechazado(v.getInvalidValue());
			// ve.setError(v.getMessage());
			listValidationError.add(ve);

			if (propertyName == null || "".equals(propertyName)) {
				errors.reject(constraintName, v.getMessage());
			} else {
				errors.rejectValue(propertyName, constraintName, v.getMessage());
			}
		}
		return violations.size() == 0;
	}

	private void printValidatorGroups(Class<?>[] validatorGroups) {
		for (@SuppressWarnings("rawtypes")
		Class c : validatorGroups) {
			log.info("validando: {}", c.getSimpleName());
		}
	}

}
