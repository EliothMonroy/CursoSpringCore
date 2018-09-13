package org.certificatic.spring.core.practica20.resources.bean;

import org.springframework.core.io.Resource;

import lombok.Data;

@Data
public class Resources {
	private Resource txtFile;
	private Resource propertiesFile;
	private Resource urlFile;
	private Resource imageFile;
}
