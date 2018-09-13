package org.certificatic.spring.soba.dao.hibernate.impl;

import java.util.List;

import org.certificatic.spring.soba.dao.api.IMovementDAO;
import org.certificatic.spring.soba.domain.Movement;
import org.springframework.stereotype.Repository;

@Repository
public class MovementDAO extends GenericEntityDAO<Movement, Long> implements IMovementDAO {

	public MovementDAO() {
		super(Movement.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Movement> findByAccountId(Long id) {
		return (List<Movement>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE account.id = " + id)
				.list();
	}

}
