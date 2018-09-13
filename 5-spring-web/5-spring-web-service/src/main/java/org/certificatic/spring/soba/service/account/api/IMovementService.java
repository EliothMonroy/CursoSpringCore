package org.certificatic.spring.soba.service.account.api;

import java.util.List;

import org.certificatic.spring.soba.domain.Movement;

public interface IMovementService {

	List<Movement> getByAccountId(Long accountId);

}
