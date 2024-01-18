package com.evently.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

public class UsersController {
	
	@PostMapping("inscription")
	public void inscription() {
		
		System.out.println("Inscription");
	}
	

}
