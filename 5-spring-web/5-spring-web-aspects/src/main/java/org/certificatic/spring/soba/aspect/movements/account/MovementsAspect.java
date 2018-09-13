package org.certificatic.spring.soba.aspect.movements.account;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.certificatic.spring.soba.dao.api.IMovementDAO;
import org.certificatic.spring.soba.domain.Account;
import org.certificatic.spring.soba.domain.Movement;
import org.certificatic.spring.soba.domain.catalogs.MovementType;
import org.certificatic.spring.soba.domain.vo.CustomDate;
import org.certificatic.spring.soba.util.Color;
import org.certificatic.spring.soba.util.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MovementsAspect {

	@Autowired
	private IColorWriter colorWriter;

	@Autowired
	private IMovementDAO movementDAO;

	@AfterReturning(
			value = "org.certificatic.spring.soba.aspect.movements.account.pointcut.MovementsPointcutDefinition.accountTransferPointcut() && "
					+ "args(origin, destination, amount, description)",
			returning = "referenceNumber")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void beforeAccountMethodExecution(Account origin, Account destination, BigDecimal amount,
			String description, String referenceNumber) {

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format("\nOrigin Account: %s.\nDestination Account: %s.\nAmount: %s, Description: %s.",
								origin, destination, amount, description)));

		// Date now = new Date();
		CustomDate now = new CustomDate();

		Movement movement = Movement.builder().account(origin).originAccountNumber(origin.getAccountNumber())
				.destinationAccountNumber(destination.getAccountNumber()).amount(amount).type(MovementType.WITHDRAWAL)
				.operationDate(now).description(description).referenceNumber(referenceNumber).build();

		movementDAO.insert(movement);

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format("\nmovement Withdrawal: %s", movement)));

		movement = Movement.builder().account(destination).originAccountNumber(origin.getAccountNumber())
				.destinationAccountNumber(destination.getAccountNumber()).amount(amount).type(MovementType.DEPOSIT)
				.operationDate(now).description(description).referenceNumber(referenceNumber).build();

		movementDAO.insert(movement);

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format("\nmovement Deposit: %s", movement)));
	}
}
