package org.certificatic.spring.soba.mvc.aspect;

import java.util.HashMap;
import java.util.Map;

import org.certificatic.spring.soba.aspect.web.security.exception.NoUserSessionFound;
import org.certificatic.spring.soba.mvc.exception.ResponseBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(NoUserSessionFound.class)
	public String exception(NoUserSessionFound e) {

		return "redirect:/";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleError404(NoHandlerFoundException e, Model model) {
		model.addAttribute("exception", e);
		return "error404";
	}

	@ExceptionHandler(HttpSessionRequiredException.class)
	public String handleRequiredSession(HttpSessionRequiredException e, Model model) {
		model.addAttribute("exception", e);
		return "redirect:/";
	}

	@ExceptionHandler(ResponseBodyException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Map<String, Object> handleException(ResponseBodyException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("status", false);
		return map;
	}
}
