package org.certificatic.spring.mvc.practica28.controller;

import org.certificatic.spring.mvc.practica28.rootbeans.BeanComponent;
import org.springframework.ui.Model;

// Anotar controller
class IndexController {

	// Inyectar required false
	private BeanComponent beanComponent;

	// anotar request mapping a "/" y a "" por GET
	public String showIndexPage(Model model) {
		// Agregar mensaje "message" al modelo
		return "index";
	}

}