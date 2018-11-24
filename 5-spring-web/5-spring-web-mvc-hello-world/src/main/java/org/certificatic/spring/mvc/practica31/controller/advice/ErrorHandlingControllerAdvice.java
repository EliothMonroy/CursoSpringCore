package org.certificatic.spring.mvc.practica31.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//Anotar Controller Advice, asignar tipos a PersonsController.class
@ControllerAdvice
public class ErrorHandlingControllerAdvice {
	// Anotar ExceptionHandler
	@ExceptionHandler(IndexOutOfBoundsException.class)
	// Anotar Response status (internal server error)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	// Anotar ResponseBody
	public @ResponseBody RestResponseError onException(RuntimeException re) {
		return new RestResponseError(HttpStatus.INTERNAL_SERVER_ERROR, re.getMessage(), re.getClass().getSimpleName());
	}

}
