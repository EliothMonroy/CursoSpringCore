package org.certificatic.spring.mvc.practica31.controller.advice;

import org.springframework.http.HttpStatus;

//Anotar Controller Advice, asignar tipos a PersonsController.class
public class ErrorHandlingControllerAdvice {

	// Anotar ExceptionHandler
	// Anotar Response status (internal server error)
	// Anotar ResponseBody
	public RestResponseError onException(RuntimeException re) {
		return new RestResponseError(HttpStatus.INTERNAL_SERVER_ERROR, re.getMessage(), re.getClass().getSimpleName());
	}

}
