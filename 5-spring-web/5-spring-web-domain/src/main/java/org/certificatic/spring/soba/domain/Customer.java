package org.certificatic.spring.soba.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

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
@Table(name = "CUSTOMER_TBL")
@ToString(exclude = { "accounts" })
@EqualsAndHashCode(exclude = { "accounts" })
public class Customer implements ILogableUser {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USER_ID")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@Cascade(value = { org.hibernate.annotations.CascadeType.DELETE })
	private @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) List<Account> accounts = new ArrayList<>();
}
