package org.certificatic.spring.mvc.practica28.controller;

import org.certificatic.spring.mvc.practica28.rootbeans.BeanComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Anotar controller
@Controller
class IndexController {

	// Inyectar required false
	@Autowired
	private BeanComponent beanComponent;

	// anotar request mapping a "/" y a "" por GET
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showIndexPage(Model model) {

		// Agregar mensaje "message" al modelo
		model.addAttribute("message", "Ivan !");

		return "index";
	}

}