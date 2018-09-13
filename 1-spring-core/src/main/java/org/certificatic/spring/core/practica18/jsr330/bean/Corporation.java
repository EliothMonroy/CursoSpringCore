package org.certificatic.spring.core.practica18.jsr330.bean;

import java.util.Optional;

import org.certificatic.spring.core.practica18.jsr330.bean.api.IDirector;

import lombok.Data;

@Data
public class Corporation {

	private IDirector generalDirector;

	private IDirector itDirector;

	private Optional<Secretary> generalSecretary;

	private Secretary secretaryAssistant;

	private Manager manager;
}
