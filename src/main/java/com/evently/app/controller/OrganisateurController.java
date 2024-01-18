package com.evently.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evently.app.model.Organisateur;
import com.evently.app.service.OrganisateurService;

@RestController
@RequestMapping(path="/api/v1/rest" , name = "evently_app")

public class OrganisateurController {
	private OrganisateurService organisateurService;
	
	@Autowired
	public OrganisateurController(OrganisateurService organisateurService) {
		this.organisateurService = organisateurService;
	}
	@PostMapping(path = "/organisateurs", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Organisateur add (@RequestBody Organisateur organisateur) {
		return this.organisateurService.saveOrganisateur(organisateur);
	}
	
	@GetMapping(path = "/organisateurs",name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Organisateur> list(){
		return this.organisateurService.getAllOrganisateurs();
		 
	}
	@GetMapping(path = "/organisateurs/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Organisateur> read(@PathVariable Long id){
		return this.organisateurService.getOneOrganisateur(id);
	}
	
	@PutMapping(path = "/organisateurs/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Organisateur update (@RequestBody Organisateur organisateur , @PathVariable Long id) {
		return this.organisateurService.updateOrganisateur(organisateur, id);
	}
	@DeleteMapping(path = "/organisateurs/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.organisateurService.removeOrganisateur(id);
	}
}
