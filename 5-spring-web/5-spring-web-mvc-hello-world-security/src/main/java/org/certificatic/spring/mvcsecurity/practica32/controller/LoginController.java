package org.certificatic.spring.mvcsecurity.practica32.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	// Anotar request mapping a "", "/" y "/login", por m�todo GET
	@RequestMapping(value= {"","/","/login"},method=RequestMethod.GET)
	public String showLoginPage(Model model, @RequestParam(required=false, value="error") boolean error) {

		log.info("show login page ------------------");

		// Verificar si existe error en la autenticaci�n
		// Si existe error agregar mensaje de error al Modelo
		if(error) {
			model.addAttribute("errorMessage", "Wrong user or password");
		}

		model.addAttribute("currentSecc", "login");

		return "login/view_login";
	}

	// Anotar request mapping a "/access-denied", por m�todo GET
	@RequestMapping(value= "/access-denied",method=RequestMethod.GET)
	public String showAccessDeniedPage() {

		log.info("show access-denied page ------------------");

		return "login/view_access_denied";
	}

}
