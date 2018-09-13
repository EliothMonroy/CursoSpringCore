package org.certificatic.spring.orm.practica27.test.dao.hibernate;

import java.util.List;

import org.certificatic.spring.orm.dao.api.IAccountDAO;
import org.certificatic.spring.orm.dao.api.ICustomerDAO;
import org.certificatic.spring.orm.dao.api.IUserDAO;
import org.certificatic.spring.orm.domain.entities.Account;
import org.certificatic.spring.orm.domain.entities.Customer;
import org.certificatic.spring.orm.domain.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "classpath:/spring/practica27/orm-hibernate4-application-context.xml")
@Transactional
@Rollback(false)
@ActiveProfiles("h2-in-memory")
public class HibernateDAOTest {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IAccountDAO accountDAO;

	@Before
	public void setUp() {
		Assert.assertNotNull(userDAO);
		Assert.assertNotNull(customerDAO);
		Assert.assertNotNull(accountDAO);
	}

	@Test
	public void hibernateDAOTest() {
		log.info("hibernateDAOTest -------------------");

		User user = userDAO.findById(1L);

		Customer customer = customerDAO.findById(1L);

		List<Account> accounts = accountDAO.findByCustomerId(customer.getId());

		Account account_2 = accountDAO.findById(2L);

		Assert.assertNotNull(user);
		Assert.assertNotNull(customer);
		Assert.assertNotNull(accounts);
		Assert.assertNotNull(account_2);

		Assert.assertEquals("xvanhalenx", user.getUsername());
		Assert.assertEquals("Ivan Venor", customer.getName());
		Assert.assertEquals(account_2, accounts.get(1));

		log.info("user: {}", user);
		log.info("user.customer: {}", user.getCustomer());
		log.info("customer: {}", customer);

		log.info("accounts: {}", accounts);
		log.info("account_2: {}", account_2);

	}
}
