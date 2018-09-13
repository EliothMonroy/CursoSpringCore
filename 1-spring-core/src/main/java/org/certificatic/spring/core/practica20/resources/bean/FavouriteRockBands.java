package org.certificatic.spring.core.practica20.resources.bean;

import lombok.Data;

@Data
// Definir bean componente
public class FavouriteRockBands {

	// Inyectar valor ${favourite.rockband.first}
	private String firstRockBand;

	// Inyectar valor ${favourite.rockband.second}
	private String secondRockBand;

	// Inyectar valor "My favourites rockbands are: ${favourite.rockband.first}
	// and ${favourite.rockband.second}"
	private String toString;

	public String toString() {
		return toString;
	}
}
