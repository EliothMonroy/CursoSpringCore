package org.certificatic.spring.jdbc.pratica25.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	private Long id;

	private String name;

	private String lastName;

	private User user;

}
