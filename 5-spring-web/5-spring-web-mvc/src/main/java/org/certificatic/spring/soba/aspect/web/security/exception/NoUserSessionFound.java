package org.certificatic.spring.soba.aspect.web.security.exception;

public class NoUserSessionFound extends RuntimeException {

	private static final long serialVersionUID = -5327442910706150622L;

	public NoUserSessionFound() {
		super();
	}

	public NoUserSessionFound(String message) {
		super(message);
	}

	public NoUserSessionFound(String message, Throwable cause) {
		super(message, cause);
	}

	public NoUserSessionFound(Throwable cause) {
		super(cause);
	}

	protected NoUserSessionFound(String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
