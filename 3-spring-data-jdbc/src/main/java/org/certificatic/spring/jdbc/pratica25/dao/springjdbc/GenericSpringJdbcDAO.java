package org.certificatic.spring.jdbc.pratica25.dao.springjdbc;

import java.io.Serializable;

import org.certificatic.spring.jdbc.pratica25.dao.IGenericDAO;

public abstract class GenericSpringJdbcDAO<T, ID extends Serializable>
		implements IGenericDAO<T, ID> {

	// Inyectar JdbcTemplate

	// Inyectar NamedParameterJdbcTemplate

}
