package org.certificatic.spring.core.tarea2.namespaces.pcutil.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class Agenda {
	private List<String> notas;
	private Set<Auto> autosFamilia;
	private Map<String, Integer> numeros;
	private Properties properties;
}
