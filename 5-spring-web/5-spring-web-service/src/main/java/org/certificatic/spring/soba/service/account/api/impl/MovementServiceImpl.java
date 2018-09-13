package org.certificatic.spring.soba.service.account.api.impl;

import java.util.List;

import org.certificatic.spring.soba.dao.api.IMovementDAO;
import org.certificatic.spring.soba.domain.Movement;
import org.certificatic.spring.soba.service.account.api.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovementServiceImpl implements IMovementService {

	@Autowired
	private IMovementDAO movementDAO;

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<Movement> getByAccountId(Long accountId) {
		return this.movementDAO.findByAccountId(accountId);
	}

}
