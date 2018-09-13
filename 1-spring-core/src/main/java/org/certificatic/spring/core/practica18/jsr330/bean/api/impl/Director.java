package org.certificatic.spring.core.practica18.jsr330.bean.api.impl;

import org.certificatic.spring.core.practica18.jsr330.bean.Budget;
import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.api.IDirector;

import lombok.Data;

@Data
public class Director implements IDirector {
	private Employee employee;
	private Budget budget = new Budget();
}
