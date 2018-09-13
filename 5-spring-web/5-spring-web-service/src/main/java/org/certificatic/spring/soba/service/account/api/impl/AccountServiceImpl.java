package org.certificatic.spring.soba.service.account.api.impl;

import java.math.BigDecimal;
import java.util.List;

import org.certificatic.spring.soba.dao.api.IAccountDAO;
import org.certificatic.spring.soba.domain.Account;
import org.certificatic.spring.soba.service.account.api.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDAO accountDAO;

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Account getByAccountId(@NonNull Long id) {
		return this.accountDAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<Account> getByCustomerId(@NonNull Long id) {
		return this.accountDAO.findByCustomerId(id);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public String transfer(@NonNull Account origin, @NonNull Account destination, @NonNull BigDecimal amount,
			@NonNull String description) {

		if (origin.getBalance().compareTo(amount) < 0)
			throw new RuntimeException("Origin Account doesn't have enough balance to do this operation");

		origin.setBalance(origin.getBalance().subtract(amount));

		destination.setBalance(destination.getBalance().add(amount));

		accountDAO.update(destination);

		accountDAO.update(origin);

		return generateRandomReferenceNumber(12);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public void create(Account account) {
		this.accountDAO.insert(account);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public Account delete(Account account) {
		return this.accountDAO.delete(account.getId());
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Account getByAccountNumber(String accountNumber) {
		return this.accountDAO.findByAccountNumber(accountNumber);
	}

}
