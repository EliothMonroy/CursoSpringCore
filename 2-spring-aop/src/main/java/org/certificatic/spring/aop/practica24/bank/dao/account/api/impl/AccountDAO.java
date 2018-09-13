package org.certificatic.spring.aop.practica24.bank.dao.account.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.practica24.bank.dao.account.api.IAccountDAO;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AccountDAO implements IAccountDAO {

	@Override
	public List<Account> findByCustomerId(Long customerId) {
		log.info(
				"Inside accountDAO.findByCustomerId(). Finding accounts for customer: {}",
				customerId);

		log.info("Finding Accounts ...");

		List<Account> result = new ArrayList<>();
		result.add(Account.builder().accountNumber("000001")
				.accountDescription("Account 1").build());
		return result;
	}

	@Override
	public void updateBalance(Account account, Long amount) {
		log.info("Inside accountDAO.updateBalance(). Account: {}, ammount: {}",
				account.getAccountNumber(),
				amount);

		log.info("Updating Account Balance ...");
	}

	@Override
	public void updateDescription(Account account) {
		log.info(
				"Inside accountDAO.updateDescription(). Updating account [{}] description to: {}",
				account.getAccountNumber(), account.getAccountDescription());

		log.info("Updating Account Description ...");

	}

}
