package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.EvenementNotFoundException;
import com.evently.app.model.Evenement;
import com.evently.app.repository.EvenementRepository;

@Service 
public class EvenementService {
	private EvenementRepository evenementRepository;
	
	public EvenementService(EvenementRepository evenementRepository) {
		this.evenementRepository = evenementRepository;
	}
	//Ajout d'un evenement
	
	public Evenement saveEvenement(Evenement evenement) {
		return this.evenementRepository.save(evenement);
	}
	//afficher la liste des evenements
	public List<Evenement>getAllEvenements(){
		
		return this.evenementRepository.findAll();
	}
	//Afficher les details d'un evenements
	public Optional<Evenement>getOneEvenement(Long id){
		
Optional<Evenement> evenement = this.evenementRepository.findById(id);
		
		if(!evenement.isPresent()) {
			throw new EvenementNotFoundException(String.format("Evenement avec le id %s introuvable" + id));
		}
			
		return this.evenementRepository.findById(id);
	}
	//Mettre à jour un evenement
	public Evenement updateEvenement(Evenement evenement , Long id) {
		
		Optional<Evenement> evenementExist = this.evenementRepository.findById(id);
		if(!evenementExist.isPresent()) {
			throw new EvenementNotFoundException(String.format("Evenement avec le id %s introuvable" + id));	
		}
		return this.evenementRepository.save(evenement);
	}
	//Supprimer un evenement
	public void removeEvenement(Long id) {
Optional<Evenement> evenement = this.evenementRepository.findById(id);
		
		if(!evenement.isPresent()) {
			throw new EvenementNotFoundException(String.format("Evenement avec le id %s introuvable" + id));
		}
		
	}
}
