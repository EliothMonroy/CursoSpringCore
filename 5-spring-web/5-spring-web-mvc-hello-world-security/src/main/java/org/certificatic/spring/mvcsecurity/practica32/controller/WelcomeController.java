package org.certificatic.spring.mvcsecurity.practica32.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("controllerBean")
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String showWelcomePage(Model model) {

		log.info("show welcome page ------------------");

		// Obtener objeto Authentication
		// Obtener username

		// Obtener Authorities

		// log.info("username : {}", username);
		// log.info("authorities : {}", authorities);

		model.addAttribute("currentSecc", "welcome");

		return "secure/view_welcome";
	}

}
