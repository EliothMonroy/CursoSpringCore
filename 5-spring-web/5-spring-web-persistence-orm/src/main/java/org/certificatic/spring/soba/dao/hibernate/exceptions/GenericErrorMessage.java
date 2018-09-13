package org.certificatic.spring.soba.dao.hibernate.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericErrorMessage {
	protected String errorId;
	protected String error;
}
