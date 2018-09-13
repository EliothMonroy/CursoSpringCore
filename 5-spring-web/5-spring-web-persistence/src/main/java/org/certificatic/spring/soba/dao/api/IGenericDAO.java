package org.certificatic.spring.soba.dao.api;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {

	void insert(final T entity);

	void insert(final T entity, final Class<?>... validatorGroups);

	void update(final T entity);

	void update(final T entity, final Class<?>... validatorGroups);

	void detach(final T entity);

	T findById(final ID id);

	T delete(final ID id);

	T delete(final T entity);

	List<T> findAll();
}
