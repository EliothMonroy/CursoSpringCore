package org.certificatic.spring.core.practica4.movies.service;

import org.certificatic.spring.core.practica4.movies.api.IMovieFinder;
import org.certificatic.spring.core.practica4.movies.model.Movie;

import lombok.Setter;

public class MovieListener {

	private @Setter IMovieFinder movieFinder;

	public Movie buscarPelicula(String titulo) {

		return movieFinder.find(titulo);

	}

}
