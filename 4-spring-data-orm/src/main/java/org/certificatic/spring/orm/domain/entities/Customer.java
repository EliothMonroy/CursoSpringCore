package org.certificatic.spring.orm.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
// Habilitar Entidad JPA
// Habilitar nombre de tabla SPRING_DATA_CUSTOMER_TBL
@ToString(exclude = { "accounts" })
@EqualsAndHashCode(exclude = { "accounts" })
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LAST_NAME")
	private String lastName;

	// Anotar mapeo one-to-one Fetch.EAGER y cascade.ALL mapeado por el
	// atributo customer de la Tabla User
	private User user;

	// Anotar mapeo one-to-many Fetch.Lazy mapeado por el
	// atributo customer de la Tabla Account
	// Anotar Cascada sólo para DELETE (cascada de hibernate no de JPA)
	private @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) List<Account> accounts = new ArrayList<>();
}
