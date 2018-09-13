package org.certificatic.spring.core.practica18.jsr330.bean;

import java.util.List;

import lombok.Data;

@Data
public class Team {
	protected List<String> employees;

	protected Employee architect;
	protected Employee programmer;
	protected Employee tester;
}
