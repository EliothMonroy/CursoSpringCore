package org.certificatic.spring.jdbc.pratica25.dao.springjdbc;

import java.io.Serializable;

import org.certificatic.spring.jdbc.pratica25.dao.IGenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import lombok.Getter;
import lombok.Setter;

public abstract class GenericSpringJdbcDAO<T, ID extends Serializable>
		implements IGenericDAO<T, ID> {

	// Inyectar JdbcTemplate
	@Autowired
	protected @Setter JdbcTemplate jdbcTemplate;

	// Inyectar NamedParameterJdbcTemplate
	protected @Getter NamedParameterJdbcTemplate namedJdbcTemplate;
}
