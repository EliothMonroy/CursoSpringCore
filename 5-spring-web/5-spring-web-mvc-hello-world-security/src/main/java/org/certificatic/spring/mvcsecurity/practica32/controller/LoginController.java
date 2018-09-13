package org.certificatic.spring.mvcsecurity.practica32.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	// Anotar request mapping a "", "/" y "/login", por método GET
	public String showLoginPage(Model model) {

		log.info("show login page ------------------");

		// Verificar si existe error en la autenticación
		// Si existe error agregar mensaje de error al Modelo

		model.addAttribute("currentSecc", "login");

		return "login/view_login";
	}

	// Anotar request mapping a "/access-denied", por método GET
	public String showAccessDeniedPage() {

		log.info("show access-denied page ------------------");

		return "login/view_access_denied";
	}

}
