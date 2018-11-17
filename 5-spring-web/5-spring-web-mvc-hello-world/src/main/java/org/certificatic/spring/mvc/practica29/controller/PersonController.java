package org.certificatic.spring.mvc.practica29.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.certificatic.spring.validation.practica30.parte1.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// Implementar request mapping "/person"
@RequestMapping("/person")
// Implementar Sessiones (después) "personCreated", "servertime"
@SessionAttributes({ "personCreated", "servertime" })
class PersonController {

	private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());

	// /person o /person/
	// Implementar request mapping "/" y "" por metodo GET
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showPersonsPage(Model model) {

		log.info("showPersonsPage ---------------->");

		// Agregar la coleccion persons al modelo
		model.addAttribute("persons", persons);

		// Agregar comando "personForm"
		model.addAttribute("personForm", new Person());

		return "person/list_and_create_person";
	}

	// /person/create
	// Implementar request mapping "/create" por metodo POST
	// Recibir como argumento el Person que proviene del formulario
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPerson(Model model, @ModelAttribute Person personForm) {

		log.info("createPerson ---------------->");

		log.info("processing form ...............");

		personForm.setId(persons.size() + 1);

		// Agregar el person que proviene del formulario al listado "persons"
		persons.add(personForm);

		// Agregar "personCreated" al modelo siendo éste objeto el obtenido
		// desde el formulario
		model.addAttribute("personCreated", personForm);

		// Agregar "servertime" (new Date()) al modelo
		model.addAttribute("servertime", new Date());

		// return "person/show_person_data"; // forward
		return "redirect:/person/showdata"; // sendRedirect
	}

	// En sessiones es necesario obtener los objetos de la sesión mediante el
	// valor explicito sobre la anotación @ModelAttribute.
	// Implementar request mapping "/showdata" por metodo GET
	@RequestMapping(value = "/showdata", method = RequestMethod.GET)
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