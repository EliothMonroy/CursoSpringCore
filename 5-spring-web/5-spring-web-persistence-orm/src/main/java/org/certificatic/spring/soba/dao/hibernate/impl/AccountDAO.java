package org.certificatic.spring.soba.dao.hibernate.impl;

import java.util.List;

import org.certificatic.spring.soba.dao.api.IAccountDAO;
import org.certificatic.spring.soba.domain.Account;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO extends GenericEntityDAO<Account, Long> implements IAccountDAO {

	public AccountDAO() {
		super(Account.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Account> findByCustomerId(Long id) {
		return (List<Account>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE customer.id = " + id)
				.list();
	}

	@Override
	public Account findByAccountNumber(String accountNumber) {
		String hql = "FROM " + this.persistentClass.getName() +
				" WHERE accountNumber = :accountNumber";

		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

		query.setParameter("accountNumber", accountNumber);

		return (Account) query.uniqueResult();
	}

}
