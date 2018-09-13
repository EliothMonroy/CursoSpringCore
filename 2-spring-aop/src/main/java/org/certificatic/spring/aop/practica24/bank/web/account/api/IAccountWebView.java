package org.certificatic.spring.aop.practica24.bank.web.account.api;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;

public interface IAccountWebView {

	void showAccountsFromCustomerId(Long customerId);

	void processFormUpdateBalance(Account account, Long amount);

	void processFormUpdateDescription(Account account);

}
