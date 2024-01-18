package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.ClientNotFoundException;
import com.evently.app.model.Client;
import com.evently.app.repository.ClientRepository;

@Service 
public class ClientService {
	private ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	//Ajout d'un client
	
	public Client saveClient(Client client) {
		return this.clientRepository.save(client);
	}
	//afficher la liste des clients
	public List<Client>getAllClients(){
		
		return this.clientRepository.findAll();
	}
	//Afficher les details d'un clients
	public Optional<Client>getOneClient(Long id){
		
Optional<Client> client = this.clientRepository.findById(id);
		
		if(!client.isPresent()) {
			throw new ClientNotFoundException(String.format("Client avec le id %s introuvable" + id));
		}
			
		return this.clientRepository.findById(id);
	}
	//Mettre à jour un client
	public Client updateClient(Client client , Long id) {
		
		Optional<Client> clientExist = this.clientRepository.findById(id);
		if(!clientExist.isPresent()) {
			throw new ClientNotFoundException(String.format("Client avec le id %s introuvable" + id));
			
		}
		return this.clientRepository.save(client);
	}
	//Supprimer un client
	public void removeClient(Long id) {
Optional<Client> client = this.clientRepository.findById(id);
		
		if(!client.isPresent()) {
			throw new ClientNotFoundException(String.format("Client avec le id %s introuvable" + id));
		}
		
	}
}
