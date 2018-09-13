package org.certificatic.spring.soba.test.service.account;

import java.math.BigDecimal;

import org.certificatic.spring.soba.domain.Account;
import org.certificatic.spring.soba.service.account.api.IAccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/service/test-service-application-context.xml")
public class AccountServiceTest {

	@Autowired
	private IAccountService accountService;

	@Before
	public void setUp() {
		Assert.assertNotNull(accountService);
	}

	@Test
	public void testa() {
		log.info("testa");

		Account account1 = accountService.getByAccountId(1L);
		Account account2 = accountService.getByAccountId(2L);

		BigDecimal amount = new BigDecimal(50000);
		BigDecimal originalAmountAccount1 = account1.getBalance();
		BigDecimal originalAmountAccount2 = account2.getBalance();

		log.info("account1: {}", account1);
		log.info("account2: {}", account2);

		accountService.transfer(account1, account2, new BigDecimal(50000), "Gift");

		Assert.assertEquals(account1.getBalance(), originalAmountAccount1.subtract(amount));
		Assert.assertEquals(account2.getBalance(), originalAmountAccount2.add(amount));

		log.info("account1: {}", account1);
		log.info("account2: {}", account2);

		log.info("originalAmountAccount1: {}", originalAmountAccount1);
		log.info("originalAmountAccount2: {}", originalAmountAccount2);
	}
}
