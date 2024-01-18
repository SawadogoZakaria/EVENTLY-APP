package com.evently.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND )
public class OrganisateurNotFoundException extends RuntimeException {
	public OrganisateurNotFoundException(String message) {
		super(message);
	}

}
