package org.certificatic.spring.mvc.practica28.controller.admin;

import org.certificatic.spring.mvc.practica28.rootbeans.BeanComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Definir controllr
@Controller
// Anotar request mapping "/admin"
@RequestMapping("/admin")
class AdminController {

	// inyectar required false
	@Autowired(required=false)
	private BeanComponent beanComponent;

	// anotar request mapping "/", "" por GET)
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String showIndexPage(Model model) {

		// enviar mensaje "message" al modelo
		String saludo=beanComponent.sayHello("Hola Elioth");
		model.addAttribute("message",saludo+"!");

		return "admin";
	}

}