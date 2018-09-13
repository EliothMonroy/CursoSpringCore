package org.certificatic.spring.mvc.practica28.controller.admin;

import org.certificatic.spring.mvc.practica28.rootbeans.BeanComponent;
import org.springframework.ui.Model;

// Definir controllr
// Anotar request mapping "/admin"
class AdminController {

	// inyectar required false
	private BeanComponent beanComponent;

	// anotar request mapping "/", "" por GET)
	public String showIndexPage(Model model) {

		// enviar mensaje "message" al modelo

		return "admin";
	}

}