package org.certificatic.spring.soba.dao.api;

import java.util.List;

import org.certificatic.spring.soba.domain.Movement;

public interface IMovementDAO extends IGenericDAO<Movement, Long> {

	List<Movement> findByAccountId(Long id);
}
