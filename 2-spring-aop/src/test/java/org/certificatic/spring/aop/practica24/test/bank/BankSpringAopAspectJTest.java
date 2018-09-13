package org.certificatic.spring.aop.practica24.test.bank;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.practica24.bank.web.account.api.IAccountWebView;
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
@ContextConfiguration(
		locations = "classpath:/spring/practica24/bank-aop-aspectj-application-context.xml")
public class BankSpringAopAspectJTest {

	@Autowired
	private IAccountWebView accountWebView;

	@Before
	public void setUp() {
		Assert.assertNotNull(accountWebView);
	}

	@Test
	public void bankSpringAopAspectJTest1() {

		log.info("bankSpringAopAspectJTest1 -------------------");

		Account account = Account.builder().accountNumber("123123")
				.accountDescription("My favourite account").build();

		accountWebView.processFormUpdateDescription(account);
	}

	@Test
	public void bankSpringAopAspectJTest2() {

		log.info("bankSpringAopAspectJTest2 -------------------");

		Account account = Account.builder().accountNumber("123123")
				.accountDescription("My favourite account").build();

		accountWebView.processFormUpdateBalance(account, 560500L);
	}

	@Test
	public void bankSpringAopAspectJTest3() {

		log.info("bankSpringAopAspectJTest3 -------------------");

		accountWebView.showAccountsFromCustomerId(5L);
	}

}
