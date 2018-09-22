package org.certificatic.spring.core.practica4.movies.service;

import org.certificatic.spring.core.practica4.movies.api.impl.MovieFinderImpl;
import org.certificatic.spring.core.practica4.movies.model.Movie;

import lombok.Setter;

public class MovieListener {
	//Esto es inmutable porque no hay setters
	//Es thread safe debido a que el objeto implementado no es mutable aunque aquí haya un setter
	public @Setter MovieFinderImpl movieFinder;
	
	public Movie buscarPelicula(String title) {
		
		return movieFinder.find(title);
	}
}
