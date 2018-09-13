package org.certificatic.spring.soba.aspect.web.security;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.certificatic.spring.soba.aspect.web.security.exception.NoUserSessionFound;
import org.certificatic.spring.soba.util.Color;
import org.certificatic.spring.soba.util.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class HttpSessionAspect {

	@Autowired
	private IColorWriter colorWriter;

	@Before("execution(* org.certificatic.spring.soba.mvc.controller..*.*(javax.servlet.http.HttpSession, ..) ) && args(session, ..)")
	public void beforeSessionWebPage(HttpSession session) {
		log.info("{}",
				colorWriter.getColoredMessage(Color.CYAN,
						"has session: " + session.getAttribute("userSession")));

		if (session.getAttribute("userSession") == null)
			throw new NoUserSessionFound("No session user");

	}

	@Pointcut("within(@org.springframework.stereotype.Controller *) && @annotation(requestMapping)")
	public void controller(RequestMapping requestMapping) {
	}

	@Before("controller(requestMapping)")
	public void advice(JoinPoint thisJoinPoint, RequestMapping requestMapping) {

		log.info("{}",
				colorWriter.getColoredMessage(Color.BLUE,
						"" + thisJoinPoint));
		log.info("{}",
				colorWriter.getColoredMessage(Color.BLUE,
						"" + requestMapping));
		log.info("{}",
				colorWriter.getColoredMessage(Color.BLUE,
						"" + requestMapping.method()[0]));
	}
}
