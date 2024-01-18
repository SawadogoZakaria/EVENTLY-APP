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

import com.evently.app.model.Client;
import com.evently.app.service.ClientService;

@RestController
@RequestMapping(path="/api/v1/rest" , name = "evently_app")

public class ClientController {
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	@PostMapping(path = "/clients", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Client add (@RequestBody Client client) {
		return this.clientService.saveClient(client);
	}
	
	@GetMapping(path = "/clients",name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Client> list(){
		return this.clientService.getAllClients();
		 
	}
	@GetMapping(path = "/clients/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Client> read(@PathVariable Long id){
		return this.clientService.getOneClient(id);
	}
	
	@PutMapping(path = "/clients/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Client update (@RequestBody Client client , @PathVariable Long id) {
		return this.clientService.updateClient(client, id);
	}
	@DeleteMapping(path = "/clients/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.clientService.removeClient(id);
	}
}
