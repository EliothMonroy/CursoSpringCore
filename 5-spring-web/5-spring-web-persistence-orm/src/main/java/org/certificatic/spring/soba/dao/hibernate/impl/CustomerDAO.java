package org.certificatic.spring.soba.dao.hibernate.impl;

import org.certificatic.spring.soba.dao.api.ICustomerDAO;
import org.certificatic.spring.soba.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO extends GenericEntityDAO<Customer, Long> implements ICustomerDAO {

	public CustomerDAO() {
		super(Customer.class);
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		return (Customer) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE user.username = '" + username + "'")
				.uniqueResult();
	}

}
