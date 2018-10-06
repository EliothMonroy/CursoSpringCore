package org.certificatic.spring.core.practica18.jsr330.bean.employees.teamx;

import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.EmployeeQualifier;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.EmployeeQualifier.EmployeeType;

@Named
@EmployeeQualifier(employeeType=EmployeeType.ARCHITECT)
public class EmployeeArchitect extends Employee {

	public EmployeeArchitect() {
		this.name = "Team Leader Architect";
		this.dni = "AA-BB-CC-DD";
	}
}
