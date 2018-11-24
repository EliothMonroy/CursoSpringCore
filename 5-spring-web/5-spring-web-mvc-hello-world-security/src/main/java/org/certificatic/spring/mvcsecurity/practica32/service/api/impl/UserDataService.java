package org.certificatic.spring.mvcsecurity.practica32.service.api.impl;

import org.certificatic.spring.mvcsecurity.practica32.service.api.IDataService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service("user-data-service")
public class UserDataService implements IDataService {

	@Override
	// Pre Authorize ROLE_USER
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getData() {
		return "user DATA ....";
	}

}
