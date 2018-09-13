package org.certificatic.spring.core.practica21.spel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOfBirth {
	private String city;
	private String country;
}
