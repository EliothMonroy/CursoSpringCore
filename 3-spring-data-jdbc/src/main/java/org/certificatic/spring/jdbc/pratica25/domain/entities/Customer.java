package org.certificatic.spring.jdbc.pratica25.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	private @Setter @Getter Long id;

	private @Setter @Getter String name;

	private @Setter @Getter String lastName;

	private @Setter @Getter User user;

}
