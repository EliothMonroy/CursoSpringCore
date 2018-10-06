package org.certificatic.spring.core.practica18.jsr330.bean;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.api.IDirector;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
@Named("acme")
public class Corporation {

	@Inject
	@Qualifier("generalDirectorBean")
	private IDirector generalDirector;

	@Inject
	private IDirector itDirector;
	
	@Inject
	@Qualifier("generalSecretaryFake")//Para indicarle que busque ese bean especifico
	private Optional<Secretary> generalSecretary;

	@Inject
	private Secretary secretaryAssistant;
	
	@Inject
	private Manager manager;
}
