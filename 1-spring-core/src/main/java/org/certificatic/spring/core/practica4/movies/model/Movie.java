package org.certificatic.spring.core.practica4.movies.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
	private String titulo1;
	private String titulo2;
	private String titulo3;
	private String titulo4;
	public static void main(String[] args) {
		Movie movi =Movie.builder().titulo1("Hola").build();
	}
}
