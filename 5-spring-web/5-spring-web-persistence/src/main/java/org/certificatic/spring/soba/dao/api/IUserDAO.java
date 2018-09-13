package org.certificatic.spring.soba.dao.api;

import org.certificatic.spring.soba.domain.User;

public interface IUserDAO extends IGenericDAO<User, Long> {

	User findByUsername(String username);
}
