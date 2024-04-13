package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import com.evently.app.model.Role;
import com.evently.app.model.Utilisateur;
import com.evently.app.repository.UtilisateurRepository;
import com.evently.app.role.TypeDeRole;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.evently.app.exception.ClientNotFoundException;
import com.evently.app.model.Client;
import com.evently.app.repository.ClientRepository;

@Service
@RequiredArgsConstructor
//@Primary
@AllArgsConstructor
public class ClientService implements UserDetailsService {
	@Autowired
	private ClientRepository clientRepository;
	UtilisateurRepository utilisateurRepository;

	public ClientService(UtilisateurService utilisateurService, BCryptPasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
    }
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;

	//Ajout d'un client


/*
	public Client  saveClient(Client client) {
		Utilisateur utilisateur =new Utilisateur();
		utilisateur.setEmail(client.getEmail());
		utilisateur.setMdp(client.getMdp());
		String mdpCrypter = this.passwordEncoder.encode(utilisateur.getMdp());
		utilisateur.setMdp(mdpCrypter);
		Role roleUtilisateur = new Role();
		roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
		utilisateur.setRole(roleUtilisateur);
		utilisateurService.inscription(utilisateur);
		return  this.clientRepository.save(client);

    }


	 /*
	public void inscriptionClient(Client utilisateur){

		if(!utilisateur.getEmail().contains("@")){
			throw  new RuntimeException("Votre email est invalide");
		}
		if(!utilisateur.getEmail().contains(".")){
			throw  new RuntimeException("Votre email est invalide");
		}
		Optional<Utilisateur> clientOptional = this.clientRepository.findByEmail(utilisateur.getEmail());
		if(clientOptional.isPresent()){
			throw new RuntimeException("Votre mail est dejà utilisé");
		}

		String mdpCrypter = this.passwordEncoder.encode(utilisateur.getMdp());
		utilisateur.setMdp(mdpCrypter);
		Role roleUtilisateur = new Role();
		roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
		utilisateur.setRole(roleUtilisateur);
		utilisateur = this.utilisateurRepository.save(utilisateur);
		this.validationService.enregistrer(utilisateur);
	}
	*/

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
