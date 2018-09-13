package org.certificatic.spring.aop.practica24.bank.app.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
	private String accountNumber;
	private String accountDescription;
	private BigDecimal balance;
}
