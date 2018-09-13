package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl;

import java.util.List;

import org.certificatic.spring.jdbc.pratica25.dao.api.IAccountDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@Profile({ "h2-in-memory", "h2-local", "mysql" })
public class AccountSpringJdbcDAO extends GenericSpringJdbcDAO<Account, Long>
		implements IAccountDAO {

	private static final String SELECT_ALL_ACCOUNT_WHERE_CUSTOMER_ID = "SELECT * FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = ?";
	private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM SPRING_DATA_ACCOUNT_TBL";
	private static final String SELECT_ACCOUNT = "SELECT * FROM SPRING_DATA_ACCOUNT_TBL WHERE ACCOUNT_ID = ?";

	private static final String INSERT_ACCOUNT = "INSERT INTO SPRING_DATA_ACCOUNT_TBL VALUES (null, :fkCustomerId, :accountNumber, :createdDate, :balance)";

	private static final String UPDATE_ACCOUNT_WHERE_CUSTOMER_ID = "UPDATE SPRING_DATA_ACCOUNT_TBL SET ACCOUNT_NUMBER = ?, CREATED_DATE = ?, BALANCE = ? WHERE FK_CUSTOMER_ID = ?";

	private static final String DELETE_ACCOUNT = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE ACCOUNT_ID = ?";

	@Override
	public List<Account> findByCustomerId(Long id) {

		// FIND ACCOUNT BY CUSTOMER ID

		// Implementar mediante JdbcTemplate y AccountRowMapper
		// Se espera una lista de objetos
		return null;
	}

	@Override
	public void insert(Account entity) {
		// INSERT Account

		// Implementar mediante NamedParameterJdbcTemplate, SqlParameterSource y
		// KeyHolder

	}

	@Override
	public void update(Account entity) {
		// UPDATE ACCOUNT

		// Implementar mediante JdbcTemplate
	}

	@Override
	public Account findById(Long id) {
		Account account = null;

		// FIND ACCOUNT BY ID
		try {

			// Implementar mediante JdbcTemplate y AccountRowMapper
			// Se espera un único objeto

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		return account;
	}

	@Override
	public Account delete(Long id) {
		Account account = this.findById(id);
		return this.delete(account);
	}

	@Override
	public Account delete(Account entity) {
		if (entity == null)
			return entity;

		// DELETE ACCOUNT

		// Implementar mediante JdbcTemplate

		return entity;
	}

	@Override
	public List<Account> findAll() {
		List<Account> userList = null;

		// FIND ALL Account
		// Implementar mediante JdbcTemplate y AccountRowMapper

		return userList;
	}

}
