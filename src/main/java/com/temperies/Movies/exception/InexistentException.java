package com.temperies.Movies.exception;

import org.springframework.http.HttpStatus;

public class InexistentException extends GenericException {

	public InexistentException(String message) {
		super(HttpStatus.NOT_FOUND, "The ".concat(message).concat(" doesn't exist"));
	}

}
