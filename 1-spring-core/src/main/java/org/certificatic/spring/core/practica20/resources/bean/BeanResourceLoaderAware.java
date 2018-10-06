package org.certificatic.spring.core.practica20.resources.bean;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
// Definir bean componente
@Component
// Implementar ResourceLoaderAware
public class BeanResourceLoaderAware implements ResourceLoaderAware {

	private @Setter ResourceLoader resourceLoader;

}