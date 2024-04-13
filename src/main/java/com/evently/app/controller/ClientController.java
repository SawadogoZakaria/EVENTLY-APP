package com.evently.app.controller;

import java.util.List;
import java.util.Optional;

import com.evently.app.model.Utilisateur;
import com.evently.app.security.JwtService;
import com.evently.app.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
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

import com.evently.app.model.Client;
import com.evently.app.service.ClientService;

@RestController
@EnableMethodSecurity
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,path="/api/v1/rest/clients", name = "evently_app")
@AllArgsConstructor
//@RequestMapping(path="/api/v1/rest/clients", name = "evently_app")
//@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")


public class ClientController {
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	// @PreAuthorize("hasAnyAuthority(ADMINISTRATEUR.name(), UTILISATEUR.name())")
	//@PostMapping(path = "inscription")
	public void inscription(@RequestBody Utilisateur utilisateur) {
		// log.info("Inscription");
		this.utilisateurService.inscription(utilisateur);
	}

	private ClientService clientService;
	private UtilisateurService utilisateurService;

	public ClientController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;

	}
	//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")



	// Client qui marche

/*
	@PostMapping(name="create" ,path = "inscription")
	@ResponseStatus(HttpStatus.CREATED)
	public Client add (@RequestBody Client client) {
		return (Client) this.clientService.saveClient(client);
	}

	@PostMapping(path = "inscription")
	public void inscription(@RequestBody Client client) {
		// log.info("Inscription");
		this.utilisateurService.inscription(client);

	}
	*/
		//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")
	@GetMapping(name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Client> list(){
		return this.clientService.getAllClients();
		 
	}
	//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")
	@GetMapping(path = "/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Client> read(@PathVariable Long id){
		return this.clientService.getOneClient(id);
	}
	//@PreAuthorize("hasAuthority('CLIENT)")
	@PutMapping(path = "/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Client update (@RequestBody Client client , @PathVariable Long id) {
		return this.clientService.updateClient(client, id);
	}
	//@PreAuthorize("hasAnyAuthority('ADMINISTRATEUR',CLIENT)")
	@DeleteMapping(path = "/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.clientService.removeClient(id);
	}
}
