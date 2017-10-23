package com.intuit.assignment.services;

import com.intuit.assignment.daolayer.managers.MovieManager;
import com.intuit.assignment.entities.Movie;

public class MovieService {

	private static MovieManager movieManager = MovieManager.getInstance();

	public static Movie retrieveMovies(int movieId) {
		return movieManager.getList(x -> x.getId() == movieId).get(0);
	}

}
