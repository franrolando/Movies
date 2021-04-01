package com.temperies.Movies.exception;

import org.springframework.http.HttpStatus;

public class MovieDuplicatedException extends GenericException {

	public MovieDuplicatedException() {
		super(HttpStatus.BAD_REQUEST, "The movie was created previously");
	}

	
}
