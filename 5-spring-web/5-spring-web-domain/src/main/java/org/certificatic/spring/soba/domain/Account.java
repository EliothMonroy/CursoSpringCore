package org.certificatic.spring.soba.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.certificatic.spring.soba.domain.util.DateTimeUserType;
import org.certificatic.spring.soba.domain.vo.CustomDate;
import org.hibernate.annotations.Cascade;
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
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ACCOUNT_TBL")
@ToString(exclude = { "customer", "movments" })
@EqualsAndHashCode(exclude = { "customer", "movments" })
@TypeDefs({ @TypeDef(name = "dateTimeUserType", typeClass = DateTimeUserType.class) })
public class Account {

	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CUSTOMER_ID")
	private @Getter(AccessLevel.NONE) Customer customer;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "CREATED_DATE")
	@Type(type = "dateTimeUserType")
	private CustomDate createdDate;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@Cascade(value = { org.hibernate.annotations.CascadeType.DELETE })
	private @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) List<Movement> movments = new ArrayList<>();
}
