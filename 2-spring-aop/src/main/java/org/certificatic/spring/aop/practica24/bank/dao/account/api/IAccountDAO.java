package org.certificatic.spring.aop.practica24.bank.dao.account.api;

import java.util.List;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;

public interface IAccountDAO {

	List<Account> findByCustomerId(Long customerId);

	void updateBalance(Account account, Long amount);

	void updateDescription(Account account);

}
