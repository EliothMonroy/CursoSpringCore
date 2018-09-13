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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name = "USER_TBL")
@ToString(exclude = { "authorities", "customer" })
@EqualsAndHashCode(exclude = { "authorities", "customer" })
public class User implements UserDetails {

	private static final long serialVersionUID = -6127081844917378388L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private @Getter(AccessLevel.NONE) Customer customer;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Type(type = "boolean")
	@Column(name = "ACCOUNT_NON_EXPIRED")
	private boolean accountNonExpired = true;

	@Type(type = "boolean")
	@Column(name = "ACCOUNT_NON_LOCKED")
	private boolean accountNonLocked = true;

	@Type(type = "boolean")
	@Column(name = "CREDENTIALS_NON_EXPIRED")
	private boolean credentialsNonExpired = true;

	@Type(type = "boolean")
	@Column(name = "ENABLED")
	private boolean enabled = true;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Authority> authorities = new ArrayList<>();

	@Transient
	private List<Integer> idAuthorities = new ArrayList<>();

}
