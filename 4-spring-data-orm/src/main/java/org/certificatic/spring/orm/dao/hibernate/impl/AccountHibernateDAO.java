package org.certificatic.spring.orm.dao.hibernate.impl;

import java.util.List;

import org.certificatic.spring.orm.dao.api.IAccountDAO;
import org.certificatic.spring.orm.dao.hibernate.GenericHibernateDAO;
import org.certificatic.spring.orm.domain.entities.Account;

// Habilitar bean Repository 
public class AccountHibernateDAO extends GenericHibernateDAO<Account, Long>
		implements IAccountDAO {

	public AccountHibernateDAO() {
		super(Account.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Account> findByCustomerId(Long id) {

		return (List<Account>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName()
						+ " WHERE customer = " + id)
				.list();
	}

}
