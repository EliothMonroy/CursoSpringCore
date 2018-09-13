package org.certificatic.spring.mvc.practica29.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.certificatic.spring.validation.practica30.parte1.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// Implementar request mapping "/person"
// Implementar Sessiones (después) "personCreated", "servertime"
class PersonController {

	private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());

	// Implementar request mapping "/" y "" por metodo GET
	public String showPersonsPage(Model model) {

		log.info("showPersonsPage ---------------->");

		// Agregar la coleccion persons al modelo

		// Agregar comando "personForm"

		return "person/list_and_create_person";
	}

	// Implementar request mapping "/create" por metodo POST
	// Recibir como argumento el Person que proviene del formulario
	public String createPerson(Model model) {

		log.info("createPerson ---------------->");

		log.info("processing form ...............");

		// Agregar el person que proviene del formulario al listado "persons"

		// Agregar "personCreated" al modelo siendo éste objeto el obtenido
		// desde el formulario

		// Agregar "servertime" (new Date()) al modelo

		return "person/show_person_data"; // forward
		// return "redirect:/person/showdata"; // sendRedirect
	}

	// En sessiones es necesario obtener los objetos de la sesión mediante el
	// valor explicito sobre la anotación @ModelAttribute.
	// Implementar request mapping "/showdata" por metodo GET
	public String showPerson(Model model, @ModelAttribute("personCreated") Person personCreated,
			@ModelAttribute("servertime") Date servertime) {

		log.info("showPerson ---------------->");

		// Se vuelven a agregar los datos al modelo para que sean accesibles en
		// la vista
		model.addAttribute("personCreated", personCreated);
		model.addAttribute("servertime", servertime);

		return "person/show_person_data";
	}

}