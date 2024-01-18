package com.evently.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND )
public class PrestataireNotFoundException extends RuntimeException {
	public PrestataireNotFoundException(String message) {
		super(message);
	}

}
