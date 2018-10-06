package org.certificatic.spring.core.practica18.jsr330.bean;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.api.IDirector;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryAssistantQualifier;
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
	@Qualifier("secretaryFake")
	private Optional<Secretary> generalSecretary;

	@Inject
	@SecretaryAssistantQualifier
	private Secretary secretaryAssistant;

	@Inject
	private Manager manager;
}
