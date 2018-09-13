package org.certificatic.spring.tx.programatictx.service.api;

import org.certificatic.spring.tx.pratica26.springtx.domain.BusinessObject;

public interface IProgramaticTransactionalService {

	BusinessObject returningObjectProgramaticTransactionalMethod(Long id);

	void withoutReturningObjectProgramaticTransactionalMethod(BusinessObject businessObject);
}
