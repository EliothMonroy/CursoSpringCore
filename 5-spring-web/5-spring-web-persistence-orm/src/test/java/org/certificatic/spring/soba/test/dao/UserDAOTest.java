package org.certificatic.spring.soba.test.dao;

import java.util.List;

import org.certificatic.spring.soba.dao.api.IAccountDAO;
import org.certificatic.spring.soba.dao.api.IAuthorityDAO;
import org.certificatic.spring.soba.dao.api.ICustomerDAO;
import org.certificatic.spring.soba.dao.api.IMovementDAO;
import org.certificatic.spring.soba.dao.api.IUserDAO;
import org.certificatic.spring.soba.domain.Account;
import org.certificatic.spring.soba.domain.Authority;
import org.certificatic.spring.soba.domain.Customer;
import org.certificatic.spring.soba.domain.Movement;
import org.certificatic.spring.soba.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/persistence-orm/test-persistence-application-context.xml")
@Transactional
public class UserDAOTest {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IAccountDAO accountDAO;

	@Autowired
	private IAuthorityDAO authorityDAO;

	@Autowired
	private IMovementDAO movementDAO;

	@Before
	public void setUp() {
		Assert.assertNotNull(userDAO);
	}

	@Test
	public void testa() {
		log.info("testa");

		User user = userDAO.findById(1L);
		Customer customer = customerDAO.findById(1L);

		List<Account> accounts = accountDAO.findByCustomerId(customer.getId());
		List<Authority> authorities = authorityDAO.findByUserId(customer.getUser().getId());

		Account account_2 = accountDAO.findById(2L);

		List<Movement> movements = movementDAO.findByAccountId(account_2.getId());

		Assert.assertNotNull(user);
		Assert.assertNotNull(customer);
		Assert.assertNotNull(accounts);
		Assert.assertNotNull(account_2);
		Assert.assertArrayEquals(user.getAuthorities().toArray(), authorities.toArray());
		Assert.assertNotNull(movements);

		Assert.assertEquals("xvanhalenx", user.getUsername());
		Assert.assertEquals("Ivan Venor", customer.getName());
		Assert.assertEquals(account_2, accounts.get(1));

		log.info("user: {}", user);
		log.info("customer:user {}", customer.getUser());
		log.info("customer: {}", customer);

		log.info("accounts: {}", accounts);
		log.info("account_2: {}", account_2);

		log.info("authorities: {}", authorities);
		log.info("user.authorities: {}", user.getAuthorities());

		log.info("movements: {}", movements);

	}
}
