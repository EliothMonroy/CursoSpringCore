package org.certificatic.spring.jdbc.pratica25.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {

	void insert(final T entity);

	void update(final T entity);

	T findById(final ID id);

	T delete(final ID id);

	T delete(final T entity);

	List<T> findAll();
}
