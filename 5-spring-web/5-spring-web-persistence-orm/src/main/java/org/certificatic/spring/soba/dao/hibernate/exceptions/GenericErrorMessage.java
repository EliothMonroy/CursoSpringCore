package org.certificatic.spring.soba.dao.hibernate.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericErrorMessage {
	protected String errorId;
	protected String error;
}
