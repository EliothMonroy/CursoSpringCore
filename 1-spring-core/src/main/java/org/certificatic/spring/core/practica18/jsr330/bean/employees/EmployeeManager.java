package org.certificatic.spring.core.practica18.jsr330.bean.employees;

import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.ManagerEmployeeQualifier;

@Named
@ManagerEmployeeQualifier
public class EmployeeManager extends Employee {

	public EmployeeManager() {
		this.name = "Ilse Hern�ndez";
		this.dni = "11-44-77-55";
	}
}
