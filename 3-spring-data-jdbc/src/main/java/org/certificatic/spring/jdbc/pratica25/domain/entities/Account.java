package org.certificatic.spring.jdbc.pratica25.domain.entities;

import java.math.BigDecimal;

import org.certificatic.spring.jdbc.pratica25.domain.vo.CustomDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "customer" })
public class Account {

	private Long id;

	private Customer customer;

	private String accountNumber;

	private CustomDate createdDate;

	private BigDecimal balance;

}
