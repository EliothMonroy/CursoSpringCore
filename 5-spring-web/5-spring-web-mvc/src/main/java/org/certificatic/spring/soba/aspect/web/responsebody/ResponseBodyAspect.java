package org.certificatic.spring.soba.aspect.web.responsebody;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.certificatic.spring.soba.mvc.exception.ResponseBodyException;
import org.certificatic.spring.soba.util.Color;
import org.certificatic.spring.soba.util.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ResponseBodyAspect {

	@Autowired
	private IColorWriter colorWriter;

	@Around("within(@org.springframework.stereotype.Controller *) && @annotation(responseBody)")
	public Object aroundResponseBodyMethod(ProceedingJoinPoint pjp, ResponseBody responseBody) throws Throwable {
		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						"Intercepting @ResponseBody Controller method"));

		Object obj = null;

		try {
			obj = pjp.proceed();
		} catch (RuntimeException rex) {
			log.info("{}",
					colorWriter.getColoredMessage(Color.RED,
							"@ResponseBody Controller method (throw exception message: " + rex.getMessage() + ")"));
			throw new ResponseBodyException(rex.getMessage());
		}

		return obj;

	}
}
