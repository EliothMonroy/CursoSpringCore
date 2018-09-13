package org.certificatic.spring.soba.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.certificatic.spring.soba.domain.catalogs.MovementType;
import org.certificatic.spring.soba.domain.vo.CustomDate;
import org.hibernate.annotations.Type;

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
@Entity
@Table(name = "MOVEMENT_TBL")
@ToString(exclude = { "account" })
@EqualsAndHashCode(exclude = { "account" })
public class Movement {

	@Id
	@Column(name = "MOVEMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ACCOUNT_ID")
	private @Getter(AccessLevel.NONE) Account account;

	@Column(name = "ORIGIN_ACCOUNT_NUMBER")
	private String originAccountNumber;

	@Column(name = "DESTINATION_ACCOUNT_NUMBER")
	private String destinationAccountNumber;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "MOVEMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private MovementType type;

	@Column(name = "OPERATION_DATE")
	@Type(type = "dateTimeUserType")
	private CustomDate operationDate;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REFERENCE_NUMBER")
	private String referenceNumber;

}
