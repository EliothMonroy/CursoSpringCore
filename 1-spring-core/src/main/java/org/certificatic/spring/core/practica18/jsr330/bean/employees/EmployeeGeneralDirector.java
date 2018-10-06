package org.certificatic.spring.core.practica18.jsr330.bean.employees;

import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;

@Named("generalDirectorEmployee")
public class EmployeeGeneralDirector extends Employee {

	public EmployeeGeneralDirector() {
		this.name = "Jorge Garcia";
		this.dni = "55-66-99-88";
	}
}
