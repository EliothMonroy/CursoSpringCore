package org.certificatic.spring.mvc.practica31.controller.advice;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "restResponseError")
public class RestResponseError {

	private int status;
	private String message;
	private String exception;

	public RestResponseError(HttpStatus internalServerError, String message, String exception) {
		this.status = internalServerError.value();
		this.message = message;
		this.exception = exception;
	}

}
