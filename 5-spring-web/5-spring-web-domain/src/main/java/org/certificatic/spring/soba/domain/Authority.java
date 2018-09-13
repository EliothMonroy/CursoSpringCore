package org.certificatic.spring.soba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

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
@Table(name = "AUTHORITY_TBL")
@ToString(exclude = { "user" })
@EqualsAndHashCode(exclude = { "user" })
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = -7996971789804766675L;

	@Id
	@Column(name = "AUTHORITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USER_ID")
	private @Getter(AccessLevel.NONE) User user;

	@Column(name = "AUTHORITY_NAME")
	private String authorityName;

	public String getAuthority() {
		return this.authorityName;
	}
}