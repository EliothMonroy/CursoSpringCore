package org.certificatic.spring.soba.dao.hibernate.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.certificatic.spring.soba.dao.api.IAuthorityDAO;
import org.certificatic.spring.soba.domain.Authority;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDAO extends GenericEntityDAO<Authority, Long> implements IAuthorityDAO {

	private static final String DELETE_AUTHORITIES_BY_AUTHORITY_ID_IN_LIST = "DELETE FROM Authority WHERE "
			+ "id IN (:list)";

	private static final String SELECT_AUTHORITIES_BY_CUSTOMER_ID = "SELECT a FROM Authority a WHERE "
			+ "user.customer.id = :customerId";

	public AuthorityDAO() {
		super(Authority.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Authority> findByUserId(Long id) {
		return (List<Authority>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE user.id = " + id).list();
	}

	@Override
	public List<Authority> deleteByCustomerId(Long customerId) {

		Query query = this.sessionFactory.getCurrentSession()
				.createQuery(SELECT_AUTHORITIES_BY_CUSTOMER_ID);

		query.setParameter("customerId", customerId);

		@SuppressWarnings("unchecked")
		List<Authority> list = (List<Authority>) query.list();

		/*for (Authority auth : list)
			this.delete(auth);*/

		query = this.sessionFactory.getCurrentSession().createQuery(DELETE_AUTHORITIES_BY_AUTHORITY_ID_IN_LIST);

		query.setParameterList("list", list.stream().map(a -> a.getId()).collect(Collectors.toList()));

		query.executeUpdate();

		return list;
	}

}
