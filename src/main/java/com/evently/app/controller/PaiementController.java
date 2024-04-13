package com.evently.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.evently.app.model.Paiement;
import com.evently.app.service.PaiementService;

@RestController
@EnableMethodSecurity
@RequestMapping(path="/api/v1/rest" , name = "evently_app")

public class PaiementController {
	private PaiementService paiementService;
	
	@Autowired
	public PaiementController(PaiementService paiementService) {
		this.paiementService = paiementService;
	}
	@PostMapping(path = "/paiements", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Paiement add (@RequestBody Paiement paiement) {
		return this.paiementService.savePaiement(paiement);
	}
	
	@GetMapping(path = "/paiements",name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Paiement> list(){
		return this.paiementService.getAllPaiements();
		 
	}
	@GetMapping(path = "/paiements/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Paiement> read(@PathVariable Long id){
		return this.paiementService.getOnePaiement(id);
	}
	
	@PutMapping(path = "/paiements/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Paiement update (@RequestBody Paiement paiement , @PathVariable Long id) {
		return this.paiementService.updatePaiement(paiement, id);
	}
	@DeleteMapping(path = "/paiements/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.paiementService.removePaiement(id);
	}
}
