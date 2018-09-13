package org.certificatic.spring.soba.mvc.validator;

import java.math.BigDecimal;

import org.certificatic.spring.soba.domain.Account;
import org.certificatic.spring.soba.service.account.api.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CreateAccountFormValidator implements Validator {

	@Autowired
	private IAccountService accountSevice;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Account.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Account account = (Account) target;

		System.out.println("lol: " + account.getAccountNumber());
		if (account.getAccountNumber().trim().length() != 14) {
			errors.rejectValue("accountNumber", "", "Length must be equal to 14 digits.");
		} else {
			Account accountWithAccountNumber = accountSevice.getByAccountNumber(account.getAccountNumber());

			if (accountWithAccountNumber != null)
				errors.rejectValue("accountNumber", "", "Provided account number already exists.");
		}

		if (account.getBalance() == null || account.getBalance().compareTo(new BigDecimal(15000)) < 0) {
			errors.rejectValue("balance", "", "Minimum balance need to be up to $ 15,000.00.");
		}

	}

}
