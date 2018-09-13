package org.certificatic.spring.soba.dao.hibernate.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class ValidationError extends GenericErrorMessage {

	private Object oject;
	private String attribute;
	private String code;
	private Object rejectedValue;

	private String message = null;

	public ValidationError(String errorId, String error, Object object, String attribute, String code,
			Object rejectedValue) {
		super(errorId, error);
		this.oject = object;
		this.attribute = attribute;
		this.code = code;
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		if (this.message == null)
			this.message = String.format(
					"Error de validación, el objeto %s con atributo (@%s)[%s] y con valor [%s]. Mensaje: [%s] '%s'",
					oject.getClass().getSimpleName(), code, attribute, rejectedValue, errorId, error);
		return this.message;
	}
}
