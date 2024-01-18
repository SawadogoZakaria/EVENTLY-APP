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

import com.evently.app.model.Evenement;
import com.evently.app.service.EvenementService;

@RestController
@RequestMapping(path="/api/v1/rest" , name = "evently_app")

public class EvenementController {
	private EvenementService evenementService;
	
	@Autowired
	public EvenementController(EvenementService evenementService) {
		this.evenementService = evenementService;
	}
	@PostMapping(path = "/evenements", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Evenement add (@RequestBody Evenement evenement) {
		return this.evenementService.saveEvenement(evenement);
	}
	
	@GetMapping(path = "/evenements",name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Evenement> list(){
		return this.evenementService.getAllEvenements();
		 
	}
	@GetMapping(path = "/evenements/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Evenement> read(@PathVariable Long id){
		return this.evenementService.getOneEvenement(id);
	}
	
	@PutMapping(path = "/evenements/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Evenement update (@RequestBody Evenement evenement , @PathVariable Long id) {
		return this.evenementService.updateEvenement(evenement, id);
	}
	@DeleteMapping(path = "/evenements/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.evenementService.removeEvenement(id);
	}
}
