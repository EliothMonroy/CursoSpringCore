package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl.h2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.certificatic.spring.jdbc.pratica25.dao.api.ICustomerDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile({ "h2-in-memory", "h2-local" })
public class CustomerSpringJdbcDAO extends GenericSpringJdbcDAO<Customer, Long>
		implements ICustomerDAO {

	private static final String INSERT_CUSTOMER = "INSERT INTO SPRING_DATA_CUSTOMER_TBL VALUES (null, :name, :lastName)";
	private static final String INSERT_USER = "INSERT INTO SPRING_DATA_USER_TBL VALUES (null, :fkCustomerId, :username, :password)";

	private static final String UPDATE_CUSTOMER = "UPDATE SPRING_DATA_CUSTOMER_TBL SET NAME = :name, LAST_NAME = :lastName WHERE CUSTOMER_ID = :customerId";
	private static final String UPDATE_USER = "UPDATE SPRING_DATA_USER_TBL SET USERNAME = :username, PASSWORD = :password WHERE USER_ID = :userId";

	private static final String SELECT_CUSTOMER = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";
	private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT * FROM SPRING_DATA_USER_TBL WHERE FK_CUSTOMER_ID = :customerId";

	private static final String SELECT_ALL_CUSTOMER_USER = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL, SPRING_DATA_USER_TBL WHERE CUSTOMER_ID = FK_CUSTOMER_ID";

	private static final String DELETE_ACCOUNT_TABLE_WHERE_CUSTOMER_ID = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = :customerId";
	private static final String DELETE_USER_WHERE_USER_ID = "DELETE FROM SPRING_DATA_USER_TBL WHERE USER_ID = :userId";
	private static final String DELETE_CUSTOMER_WHERE_CUSTOMER_ID = "DELETE FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";

	// Borrar
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public void insert(Customer entity) {

		// INSERT CUSTOMER
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		// Implementar Settear parametros a parameterSource

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Implementar pasar argumentos a update
		this.namedJdbcTemplate.update(null, null, null);

		entity.setId(keyHolder.getKey().longValue());

		// INSERT USER
		parameterSource = new MapSqlParameterSource();

		// Implementar Settear parametros a parameterSource

		keyHolder = new GeneratedKeyHolder();

		// Implementar pasar argumentos a update
		this.namedJdbcTemplate.update(null, null, null);

		entity.getUser().setId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(Customer entity) {

		// UPDATE CUSTOMER
		Map<String, Object> mapParameters = new HashMap<>();

		// Implementar Settear parametros a mapParameters
		// Implementar NamedParameterJdbcTemplate y pasar argumentos a update

		// UPDATE USER
		mapParameters = new HashMap<>();

		// Implementar Settear parametros a mapParameters
		// Implementar NamedParameterJdbcTemplate y pasar argumentos a update

	}

	@Override
	public Customer findById(Long id) {
		Customer customer = null;

		// FIND CUSTOMER BY ID
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", id);

		try {
			customer = this.namedJdbcTemplate.queryForObject(SELECT_CUSTOMER,
					parameterSource,
					new RowMapper<Customer>() {
						@Override
						public Customer mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							// Implementar Customer solo.

							return null;
						}
					});

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		// FIND USER OF CUSTOMER BY CUSTOMER_ID
		parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", customer.getId());

		User user = this.namedJdbcTemplate.queryForObject(
				SELECT_USER_WHERE_CUSTOMER_ID, parameterSource,
				(ResultSet rs, int rowNum) -> {

					// Implementar User solo

					return null;
				});

		customer.setUser(user);
		user.setCustomer(customer);

		return customer;
	}

	@Override
	public Customer delete(Long id) {
		Customer customer = this.findById(id);
		return this.delete(customer);
	}

	@Override
	public Customer delete(Customer entity) {
		if (entity == null)
			return entity;

		// DELETE COMPLETE RELATIONS OF CUSTOMER WITH ALL TABLES
		Map<String, Object> mapParameters = new HashMap<>();

		// Implementar DELETE's utilizando NamedParameterJdbcTemplate y
		// mapParameters

		return entity;
	}

	@Override
	public List<Customer> findAll() {

		final List<Customer> customerList = new ArrayList<>();

		// FIND COMPLETE ALL CUSTOMER (WITH USER)

		// Implementar query utilizando NamedParameterJdbcTemplate y
		// RowCallbackHandler

		return customerList;
	}

}
