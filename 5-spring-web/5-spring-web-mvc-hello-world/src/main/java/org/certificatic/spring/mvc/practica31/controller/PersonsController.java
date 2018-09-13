package org.certificatic.spring.mvc.practica31.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.certificatic.spring.validation.practica30.parte1.domain.Person;
import org.certificatic.spring.validation.practica30.parte1.domain.Persons;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Anotar RestController
// Anotar request mapping "/persons"
public class PersonsController {

	private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());

	@PostConstruct
	private void init() {
		for (int i = 0; i < 3; i++) {
			Person p = new Person();
			p.setId(i + 1);
			p.setName("Ivan " + (i + 1));
			p.setAge(28 + i + 1);
			persons.add(p);
		}
	}

	// Anotar request mapping "/", "", con metodo GET y produciendo json y xml
	public Persons getAllPersons() {
		return new Persons(persons);
	}

	// Anotar request mapping "/{id}", con metodo GET y produciendo json y xml
	// Anotar response status ok
	public Person getPerson(@PathVariable Integer id) {
		return persons.get(id - 1);
	}

	// Anotar request mapping "/", "", con metodo POST y produciendo json y xml
	// Anotar response status NO CONTENT
	public void createPerson(@RequestBody Person person) {
		persons.add(person);
	}

}
