package org.certificatic.spring.mvc.practica28.rootbeans;

import org.certificatic.spring.mvc.practica28.service.api.impl.AddServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BeanComponent {

	@Autowired(required = false)
	private AddServiceImpl addService;

	public String sayHello(String name) {
		return "Hello " + name + " !";
	}

}
