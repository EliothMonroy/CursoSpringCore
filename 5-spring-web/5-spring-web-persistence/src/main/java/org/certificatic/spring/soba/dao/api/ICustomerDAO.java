package org.certificatic.spring.soba.dao.api;

import org.certificatic.spring.soba.domain.Customer;

public interface ICustomerDAO extends IGenericDAO<Customer, Long> {
	Customer getCustomerByUsername(String username);
}
