package org.certificatic.spring.mvc.practica28.service.api.impl;

import org.certificatic.spring.mvc.practica28.rootbeans.BeanComponent;
import org.certificatic.spring.mvc.practica28.service.api.IAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AddServiceImpl implements IAddService {

	@Autowired(required = false)
	private BeanComponent beanComponent;

	public Double add(Double... numbers) {

		Double z = 0D;

		if (numbers != null)
			for (Double n : numbers)
				z += n;

		return z;

	}
}
