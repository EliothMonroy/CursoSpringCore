package org.certificatic.spring.soba.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ADMIN_TBL")
public class Admin implements ILogableUser {

	@Id
	@Column(name = "ADMIN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// , mappedBy = "customer"
	@JoinColumn(name = "FK_USER_ID")
	private User user;
}
