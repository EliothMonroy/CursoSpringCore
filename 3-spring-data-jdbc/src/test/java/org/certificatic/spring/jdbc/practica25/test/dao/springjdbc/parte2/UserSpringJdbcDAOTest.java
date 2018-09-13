package org.certificatic.spring.jdbc.practica25.test.dao.springjdbc.parte2;

import java.util.List;

import org.certificatic.spring.jdbc.pratica25.dao.api.IAccountDAO;
import org.certificatic.spring.jdbc.pratica25.dao.api.ICustomerDAO;
import org.certificatic.spring.jdbc.pratica25.dao.api.IUserDAO;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "classpath:/spring/practica25/spring-jdbc-application-context.xml")
@ActiveProfiles("h2-in-memory")
public class UserSpringJdbcDAOTest {

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
	public void createUserTest() {
		log.info("createUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		userDAO.insert(newUser);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		Customer customer = customerDAO.findById(user.getCustomer().getId());

		Assert.assertEquals(user.getCustomer(), customer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));

	}

	@Test
	public void updateUserTest() {
		log.info("updateUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		userDAO.insert(newUser);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		user.getCustomer().setName("Laura Valeria");
		user.getCustomer().setLastName("Manrique");

		user.setUsername("lauravaleria123");
		user.setPassword("123456789");

		userDAO.update(user);

		log.info("user (modified) : {} {}", user,
				System.identityHashCode(user));

		User modifiedUser = userDAO.findById(user.getId());

		Assert.assertEquals(modifiedUser, user);

		log.info("modifiedUser : {} {}", modifiedUser,
				System.identityHashCode(modifiedUser));

		Customer customer = customerDAO
				.findById(modifiedUser.getCustomer().getId());

		Assert.assertEquals(customer, modifiedUser.getCustomer());

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));
	}

	@Test
	public void deleteUserTest() {
		log.info("deleteUserTest -------------------");

		User newUser = User.builder().username("laura123").password("123123")
				.build();

		Customer newCustomer = Customer.builder().name("Laura")
				.lastName("Montes").user(newUser).build();

		newUser.setCustomer(newCustomer);

		userDAO.insert(newUser);

		log.info("newUser : {} {}", newUser, System.identityHashCode(newUser));

		log.info("newUser (detached) : {} {}", newUser,
				System.identityHashCode(newUser));

		User user = userDAO.findById(newUser.getId());

		Assert.assertEquals(user, newUser);

		log.info("user : {} {}", user, System.identityHashCode(user));

		userDAO.delete(user);

		log.info("user (deleted) : {} {}", user, System.identityHashCode(user));

		User deletedUser = userDAO.findById(user.getId());

		Assert.assertNull(deletedUser);

		log.info("deletedUser : {} {}", deletedUser,
				System.identityHashCode(deletedUser));

		Customer customer = customerDAO.findById(user.getCustomer().getId());

		Assert.assertNull(customer);

		log.info("customer : {} {}", customer,
				System.identityHashCode(customer));
	}

	@Test
	public void findAllUserTest() {
		log.info("findAllUserTest -------------------");

		List<User> users = userDAO.findAll();
		log.info("users : {}", users);
	}
}
