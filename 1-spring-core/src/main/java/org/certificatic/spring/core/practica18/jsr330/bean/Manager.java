package org.certificatic.spring.core.practica18.jsr330.bean;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.certificatic.spring.core.practica18.jsr330.qualifiers.ManagerEmployeeQualifier;

import lombok.Data;

@Data
@Named
@Singleton
public class Manager {

	@Inject
	@ManagerEmployeeQualifier
	private Employee employee;

	@Resource
	private Team team1;

	@Resource
	private Team team2;
}
