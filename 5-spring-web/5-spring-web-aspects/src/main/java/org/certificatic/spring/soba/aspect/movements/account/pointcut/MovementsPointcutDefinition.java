package org.certificatic.spring.soba.aspect.movements.account.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MovementsPointcutDefinition {

	@Pointcut("execution( String org.certificatic.spring.soba.service.account.api.IAccountService.transfer( org.certificatic.spring.soba.domain.Account, org.certificatic.spring.soba.domain.Account, java.math.BigDecimal, String) ) ")
	public void accountTransferPointcut() {
	}
}
