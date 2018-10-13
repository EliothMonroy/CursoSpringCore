package org.certificatic.spring.aop.practica24.bank.service.account.api.impl;

import java.util.List;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.practica24.bank.dao.account.api.IAccountDAO;
import org.certificatic.spring.aop.practica24.bank.service.account.api.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDAO accountDAO;

	@Override
	@SneakyThrows
	public void updateAccountBalance(Account account, Long amount) {

		//Thread.sleep(300);

		accountDAO.updateBalance(account, amount);
	}

	@Override
	public List<Account> findCustomerAccounts(Long customerId) {
		return accountDAO.findByCustomerId(customerId);
	}

	@Override
	@SneakyThrows
	public void updateAccountDescription(Account account) {

		//Thread.sleep(300);

		accountDAO.updateDescription(account);
	}

}
