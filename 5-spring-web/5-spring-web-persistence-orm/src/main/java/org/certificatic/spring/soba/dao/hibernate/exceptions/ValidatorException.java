package org.certificatic.spring.soba.dao.hibernate.exceptions;

import java.util.List;

import lombok.Getter;

public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1019338402341995871L;

	protected @Getter List<ValidationError> validationErrors;

	public ValidatorException(String message, List<ValidationError> validationErrors) {
		super(message);
		this.validationErrors = validationErrors;
	}
}
