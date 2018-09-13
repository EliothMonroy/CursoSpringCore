package org.certificatic.spring.orm.dao.hibernate.api;

import java.io.Serializable;

public interface IHibernateExtraOperationsDAO<T, ID extends Serializable> {

	void detach(final T entity);
}
