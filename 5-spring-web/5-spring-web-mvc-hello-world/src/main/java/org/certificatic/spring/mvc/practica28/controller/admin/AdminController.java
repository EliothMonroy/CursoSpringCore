package org.certificatic.spring.mvc.practica28.controller.admin;

import org.certificatic.spring.mvc.practica28.rootbeans.BeanComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Definir controller
@Controller
// Anotar request mapping "/admin"
@RequestMapping("/admin")
class AdminController {

	// inyectar required false
	@Autowired
	private BeanComponent beanComponent;

	// anotar request mapping "/", "" por GET)
	// /admin o /admin/
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showIndexPage(Model model) {

		// enviar mensaje "message" al modelo
		String saludo = beanComponent.sayHello("Ivan");

		model.addAttribute("message", saludo);

		return "admin";
	}

	// /message/{name}
	@RequestMapping(value = "/message/{name}", method = RequestMethod.GET)
	public String showIndexPage2(Model model,
			@PathVariable("name") String name) {

		// Agregar mensaje "message" al modelo
		// enviar mensaje "message" al modelo
		String saludo = beanComponent.sayHello(name);

		model.addAttribute("message", saludo);

		return "admin";
	}

	// /name?name={name}
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String showIndexPage3(Model model,
			@RequestParam("name") String name) {

		// Agregar mensaje "message" al modelo
		String saludo = beanComponent.sayHello(name);

		model.addAttribute("message", saludo);

		return "admin";
	}

}