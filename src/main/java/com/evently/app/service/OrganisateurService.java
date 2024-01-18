package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.OrganisateurNotFoundException;
import com.evently.app.model.Organisateur;
import com.evently.app.repository.OrganisateurRepository;

@Service 
public class OrganisateurService {
	private OrganisateurRepository organisateurRepository;
	
	public OrganisateurService(OrganisateurRepository organisateurRepository) {
		this.organisateurRepository = organisateurRepository;
	}
	//Ajout d'un organisateur
	
	public Organisateur saveOrganisateur(Organisateur organisateur) {
		return this.organisateurRepository.save(organisateur);
	}
	//afficher la liste des organisateurs
	public List<Organisateur>getAllOrganisateurs(){
		
		return this.organisateurRepository.findAll();
	}
	//Afficher les details d'un organisateurs
	public Optional<Organisateur>getOneOrganisateur(Long id){
		
Optional<Organisateur> organisateur = this.organisateurRepository.findById(id);
		
		if(!organisateur.isPresent()) {
			throw new OrganisateurNotFoundException(String.format("Organisateur avec le id %s introuvable" + id));
		}
			
		return this.organisateurRepository.findById(id);
	}
	//Mettre à jour un organisateur
	public Organisateur updateOrganisateur(Organisateur organisateur , Long id) {
		
		Optional<Organisateur> organisateurExist = this.organisateurRepository.findById(id);
		if(!organisateurExist.isPresent()) {
			throw new OrganisateurNotFoundException(String.format("Organisateur avec le id %s introuvable" + id));
			
		}
		return this.organisateurRepository.save(organisateur);
	}
	//Supprimer un organisateur
	public void removeOrganisateur(Long id) {
Optional<Organisateur> organisateur = this.organisateurRepository.findById(id);
		
		if(!organisateur.isPresent()) {
			throw new OrganisateurNotFoundException(String.format("Organisateur avec le id %s introuvable" + id));
		}
		
	}
}
