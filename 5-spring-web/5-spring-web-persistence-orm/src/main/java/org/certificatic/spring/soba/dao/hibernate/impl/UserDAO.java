package org.certificatic.spring.soba.dao.hibernate.impl;

import org.certificatic.spring.soba.dao.api.IUserDAO;
import org.certificatic.spring.soba.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends GenericEntityDAO<User, Long> implements IUserDAO {

	public UserDAO() {
		super(User.class);
	}

	@Override
	public User findByUsername(String username) {
		return (User) this.sessionFactory.getCurrentSession()
				.createQuery("FROM " + this.persistentClass.getName() + " WHERE username = '" + username + "'")
				.uniqueResult();
	}

}
