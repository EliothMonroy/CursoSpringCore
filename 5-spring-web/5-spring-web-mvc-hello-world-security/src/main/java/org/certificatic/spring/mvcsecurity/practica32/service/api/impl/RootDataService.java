package org.certificatic.spring.mvcsecurity.practica32.service.api.impl;

import org.certificatic.spring.mvcsecurity.practica32.service.api.IDataService;
import org.springframework.stereotype.Service;

@Service("root-data-service")
public class RootDataService implements IDataService {

	@Override
	// Pre Authorize ROLE_ROOT
	public String getData() {
		return "root DATA ....";
	}

}
