package org.certificatic.spring.soba.service.account.api;

import java.util.List;

import org.certificatic.spring.soba.domain.Customer;

public interface ICustomerService {

	Customer getByCustomerId(Long id);

	List<Customer> getAll();

	void create(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

}
