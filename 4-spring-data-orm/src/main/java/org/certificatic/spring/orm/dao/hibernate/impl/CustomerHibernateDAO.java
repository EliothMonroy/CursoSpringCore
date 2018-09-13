package org.certificatic.spring.orm.dao.hibernate.impl;

import org.certificatic.spring.orm.dao.api.ICustomerDAO;
import org.certificatic.spring.orm.dao.hibernate.GenericHibernateDAO;
import org.certificatic.spring.orm.domain.entities.Customer;

//Habilitar bean Repository 
public class CustomerHibernateDAO extends GenericHibernateDAO<Customer, Long>
		implements ICustomerDAO {

	public CustomerHibernateDAO() {
		super(Customer.class);
	}

}
