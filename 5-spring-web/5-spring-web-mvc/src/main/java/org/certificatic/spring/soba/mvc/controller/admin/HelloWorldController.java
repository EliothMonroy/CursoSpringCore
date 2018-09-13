package org.certificatic.spring.soba.mvc.controller.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.certificatic.spring.soba.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloWorldController {

	@RequestMapping(value = { "/inicio" }, method = RequestMethod.GET)
	public String holaMundoSpringMVC(Locale locale, Model model) {
		Date hoy = new Date();
		DateFormat formatoFecha = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String fechaFormateada = formatoFecha.format(hoy);
		String mensaje = "Soy un mensaje generado desde el Controllador";

		model.addAttribute("hoy", fechaFormateada);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("command", new User());

		log.info("enviando: hoy: \"{}\" y mensaje: \"{}\"", fechaFormateada, mensaje);

		return "helloworld/helloworld";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(Locale locale, @ModelAttribute("SpringWeb") User user, Model model) {
		log.info("Welcome " + user.getUsername());
		model.addAttribute(user);
		return "user";
	}
}
