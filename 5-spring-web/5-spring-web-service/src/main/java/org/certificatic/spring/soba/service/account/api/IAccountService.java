package org.certificatic.spring.soba.service.account.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.certificatic.spring.soba.domain.Account;

public interface IAccountService {

	Account getByAccountId(Long id);

	Account getByAccountNumber(String accountNumber);

	List<Account> getByCustomerId(Long id);

	String transfer(Account origin, Account destination, BigDecimal amount, String description);

	void create(Account account);

	Account delete(Account account);

	default String generateRandomReferenceNumber(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return new String(digits);
	}

}
