package org.certificatic.spring.orm.domain.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.certificatic.spring.orm.domain.vo.CustomDate;
import org.certificatic.spring.orm.hibernate.customtypes.DateTimeUserType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Habilitar Entidad JPA
// Habilitar nombre de tabla SPRING_DATA_ACCOUNT_TBL
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "customer" })
@TypeDefs({ @TypeDef(name = "dateTimeUserType",
		typeClass = DateTimeUserType.class) })
public class Account {

	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// Anotar mapeo Many-to-one Fetch.Lazy
	// Anotar Join-column (columna de union) que contiene la FK a Tabla Customer
	private @Getter(AccessLevel.NONE) Customer customer;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "CREATED_DATE")
	@Type(type = "dateTimeUserType")
	private CustomDate createdDate;

	@Column(name = "BALANCE")
	private BigDecimal balance;

}
