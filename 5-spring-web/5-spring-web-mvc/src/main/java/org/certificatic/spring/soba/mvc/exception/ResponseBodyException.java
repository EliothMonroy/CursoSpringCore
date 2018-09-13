package org.certificatic.spring.soba.mvc.exception;

public class ResponseBodyException extends RuntimeException {

	private static final long serialVersionUID = 5054214853073113681L;

	public ResponseBodyException() {
		super();
	}

	public ResponseBodyException(String message) {
		super(message);
	}

	public ResponseBodyException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResponseBodyException(Throwable cause) {
		super(cause);
	}

	protected ResponseBodyException(String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}