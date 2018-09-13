package org.certificatic.spring.soba.dao.api;

import java.util.List;

import org.certificatic.spring.soba.domain.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long> {

	List<Account> findByCustomerId(Long id);

	Account findByAccountNumber(String accountNumber);
}
