package com.evently.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evently.app.model.Prestataire;
import com.evently.app.service.PrestataireService;

@RestController
@EnableMethodSecurity
@RequestMapping(path="/api/v1/rest/prestataires" , name = "evently_app")

public class PrestataireController {
	private PrestataireService prestataireService;
	
	@Autowired
	public PrestataireController(PrestataireService prestataireService) {
		this.prestataireService = prestataireService;
	}
	//@PostMapping(name="create")
	//@PreAuthorize("hasAuthority('CLIENT_CREATE')")

	//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")
	@GetMapping(name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Prestataire> list(){
		return this.prestataireService.getAllPrestataires();
		 
	}
	//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")
	@GetMapping(path = "/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Prestataire> read(@PathVariable Long id){
		return this.prestataireService.getOnePrestataire(id);
	}

	//@PreAuthorize("hasAuthority('CLIENT')")
	@PutMapping(path = "/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Prestataire update (@RequestBody Prestataire prestataire , @PathVariable Long id) {
		return this.prestataireService.updatePrestataire(prestataire, id);
	}
	//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")
	@DeleteMapping(path = "/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.prestataireService.removePrestataire(id);
	}
}
