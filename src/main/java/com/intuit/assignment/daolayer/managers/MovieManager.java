package com.intuit.assignment.daolayer.managers;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.entities.Movie;

public class MovieManager extends AbstractManager<Movie> {

	private MovieManager() {

	}

	private static final MovieManager INSTANCE = new MovieManager();

	public static MovieManager getInstance() {
		return INSTANCE;
	}

	@Override
	void validate(Movie ele) throws AppException {
	}

}
