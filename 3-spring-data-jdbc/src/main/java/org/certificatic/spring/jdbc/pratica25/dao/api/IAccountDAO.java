package org.certificatic.spring.jdbc.pratica25.dao.api;

import java.util.List;

import org.certificatic.spring.jdbc.pratica25.dao.IGenericDAO;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long> {

	List<Account> findByCustomerId(Long id);
}
