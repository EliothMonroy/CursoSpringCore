package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.certificatic.spring.jdbc.pratica25.dao.api.IUserDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.SneakyThrows;

@Repository
@Profile({ "h2-in-memory", "h2-local", "mysql" })
public class UserSpringJdbcDAO extends GenericSpringJdbcDAO<User, Long>
		implements IUserDAO {

	private static final String INSERT_CUSTOMER = "INSERT INTO SPRING_DATA_CUSTOMER_TBL VALUES (null, ?, ?)";
	private static final String INSERT_USER = "INSERT INTO SPRING_DATA_USER_TBL VALUES (null, ?, ?, ?)";

	private static final String UPDATE_CUSTOMER = "UPDATE SPRING_DATA_CUSTOMER_TBL SET NAME = ?, LAST_NAME = ? WHERE CUSTOMER_ID = ?";
	private static final String UPDATE_USER = "UPDATE SPRING_DATA_USER_TBL SET USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";

	private static final String SELECT_USER_CUSTOMER_WHERE_CUSTOMER_ID = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID WHERE USER_ID = ?";
	private static final String SELECT_ALL_USER_CUSTOMER = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID";

	// MEJORA
	@SuppressWarnings("unused")
	private static final String SELECT_ALL_CUSTOMER = "SELECT CUSTOMER_ID as ID, NAME, LAST_NAME as LASTNAME FROM SPRING_DATA_CUSTOMER_TBL";

	// MEJORA
	@SuppressWarnings("unused")
	private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT USER_ID as ID, USERNAME, PASSWORD FROM SPRING_DATA_USER_TBL WHERE FK_CUSTOMER_ID = ?";

	private static final String DELETE_ACCOUNT_WHERE_CUSTOMER_ID = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = ?";
	private static final String DELETE_USER_WHERE_USER_ID = "DELETE FROM SPRING_DATA_USER_TBL WHERE USER_ID = ?";
	private static final String DELETE_CUSTOMER_WHERE_CUSTOMER_ID = "DELETE FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = ?";

	// borrar
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(User entity) {

		// OJO REVISAR MODELO, IMPLEMENTAR LOGICA EAGER Y LAZY.

		// Implementar INSERT CUSTOMER obteniendo KeyHolder
		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Implementado mediante PreparedStatementCreator y keyHolder
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				// Implementar
				return null;
			}
		}, keyHolder);

		// Implementar INSERT USER recuperando fk_customer_id
		keyHolder = new GeneratedKeyHolder();

		// Implementado mediante PreparedStatementCreator y keyHolder
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				// Implementar
				return null;
			}
		}, keyHolder);

	}

	@Override
	public void update(User entity) {

		// Implementar UPDATE CUSTOMER

		// Implementado mediante sql y parámetros vararg
		// this.jdbcTemplate.update(UPDATE_CUSTOMER, new Object[] {});

		// Implementado mediante sql y setteo de parametros mediante
		// PreparedStatementSetter
		this.jdbcTemplate.update(UPDATE_CUSTOMER,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						// Implementar
					}
				});

		// Implementar UPDATE USER

		// Implementado mediante sql y parámetros vararg
		this.jdbcTemplate.update(UPDATE_USER, entity.getUsername(),
				entity.getPassword(), entity.getId());
	}

	@Override
	@SneakyThrows
	public User findById(Long id) {

		// OJO REVISAR MODELO, IMPLEMENTAR LOGICA EAGER Y LAZY.

		User u = null;

		// Implementar SELECT USER BY ID
		// FIND COMPLETE USER (WITH CUSTOMER) BY ID

		try {
			u = this.jdbcTemplate.queryForObject(
					SELECT_USER_CUSTOMER_WHERE_CUSTOMER_ID,
					new RowMapper<User>() {
						@Override
						public User mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							// Implementar
							return null;
						}
					}, new Object[] {});

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		return u;
	}

	@Override
	public User delete(Long id) {
		User user = this.findById(id);
		return this.delete(user);
	}

	@Override
	public User delete(User entity) {
		if (entity == null)
			return entity;

		// DELETE COMPLETE RELATIONS OF USER WITH ALL TABLES

		// Pasar parámetros a update
		this.jdbcTemplate.update(DELETE_ACCOUNT_WHERE_CUSTOMER_ID,
				new Object[] {});

		// Pasar parámetros a update
		this.jdbcTemplate.update(DELETE_USER_WHERE_USER_ID, new Object[] {});

		// Pasar parámetros a update
		this.jdbcTemplate.update(DELETE_CUSTOMER_WHERE_CUSTOMER_ID,
				new Object[] {});

		return entity;
	}

	@Override
	public List<User> findAll() {

		List<User> userList = null;

		// FIND COMPLETE ALL USER (WITH CUSTOMER)
		// Implementar mediante REsultSetExtractor
		userList = this.jdbcTemplate.query(SELECT_ALL_USER_CUSTOMER,
				new ResultSetExtractor<List<User>>() {

					@Override
					public List<User> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						// Implementar
						return null;
					}

				});

		return userList;
	}

}
