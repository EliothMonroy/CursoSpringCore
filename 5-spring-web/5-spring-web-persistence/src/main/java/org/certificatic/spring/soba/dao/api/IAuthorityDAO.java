package org.certificatic.spring.soba.dao.api;

import java.util.List;

import org.certificatic.spring.soba.domain.Authority;

public interface IAuthorityDAO extends IGenericDAO<Authority, Long> {

	List<Authority> findByUserId(Long id);

	List<Authority> deleteByCustomerId(Long customerId);
}
