package org.certificatic.spring.soba.service.account.api.impl;

import java.util.List;

import org.certificatic.spring.soba.dao.api.IAuthorityDAO;
import org.certificatic.spring.soba.dao.api.ICustomerDAO;
import org.certificatic.spring.soba.domain.Customer;
import org.certificatic.spring.soba.service.account.api.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IAuthorityDAO authorityDAO;

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<Customer> getAll() {
		return this.customerDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Customer getByCustomerId(Long id) {
		return this.customerDAO.findById(id);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public void create(Customer customer) {
		this.customerDAO.insert(customer);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public void update(Customer customer) {
		this.authorityDAO.deleteByCustomerId(customer.getId());
		this.customerDAO.update(customer);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public void delete(Customer customer) {
		this.customerDAO.delete(customer.getId());
	}

}
