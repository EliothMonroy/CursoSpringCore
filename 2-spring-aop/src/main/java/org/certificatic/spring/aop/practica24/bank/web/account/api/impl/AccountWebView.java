package org.certificatic.spring.aop.practica24.bank.web.account.api.impl;

import java.util.List;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.practica24.bank.service.account.api.IAccountService;
import org.certificatic.spring.aop.practica24.bank.web.account.api.IAccountWebView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccountWebView implements IAccountWebView {

	@Autowired
	private IAccountService accountService;

	@Override
	public void showAccountsFromCustomerId(Long customerId) {
		

		List<Account> accountList = accountService
				.findCustomerAccounts(customerId);

		accountList.stream().forEach(System.out::println);
	}

	@Override
	public void processFormUpdateBalance(Account account, Long amount) {
		

		accountService.updateAccountBalance(account, amount);
	}

	@Override
	public void processFormUpdateDescription(Account account) {
		

		accountService.updateAccountDescription(account);
	}

}
