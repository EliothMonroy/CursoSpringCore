package org.certificatic.spring.orm.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.certificatic.spring.orm.dao.IGenericDAO;
import org.certificatic.spring.orm.dao.hibernate.api.IHibernateExtraOperationsDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements IGenericDAO<T, ID>, IHibernateExtraOperationsDAO<T, ID> {

	protected @Getter final Class<T> persistentClass;

	// Inyectar SessionFactory
	@Autowired
	protected @Getter SessionFactory sessionFactory;

	public GenericHibernateDAO(final Class<T> type) {
		this.persistentClass = type;
	}

	@Override
	public void insert(T entity) {
		this.sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) this.sessionFactory.getCurrentSession()
				.get(this.persistentClass, id);
	}

	@Override
	public T delete(ID id) {
		final T entity = this.findById(id);
		return this.delete(entity);
	}

	@Override
	public T delete(T entity) {
		if (entity != null) {
			this.sessionFactory.getCurrentSession().delete(entity);
		}
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName())
				.list();
	}

	@Override
	public void detach(T entity) {
		this.sessionFactory.getCurrentSession().evict(entity);
	}

}
