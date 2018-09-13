package org.certificatic.spring.orm.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
// Habilitar Entidad JPA
// Habilitar nombre de tabla SPRING_DATA_USER_TBL
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "customer" })
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// Anotar mapeo one-to-one Fetch.EAGER y Cascade.All
	// Anotar Join-column (columna de union) que contiene la FK a Tabla Customer
	private Customer customer;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;
}
