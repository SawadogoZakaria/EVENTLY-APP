package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.PrestataireNotFoundException;
import com.evently.app.model.Prestataire;
import com.evently.app.repository.PrestataireRepository;

@Service 
public class PrestataireService {
	private PrestataireRepository prestataireRepository;
	
	public PrestataireService(PrestataireRepository prestataireRepository) {
		this.prestataireRepository = prestataireRepository;
	}
	//Ajout d'un prestataire
	
	public Prestataire savePrestataire(Prestataire prestataire) {
		return this.prestataireRepository.save(prestataire);
	}
	//afficher la liste des prestataires
	public List<Prestataire>getAllPrestataires(){
		
		return this.prestataireRepository.findAll();
	}
	//Afficher les details d'un prestataires
	public Optional<Prestataire>getOnePrestataire(Long id){
		
Optional<Prestataire> prestataire = this.prestataireRepository.findById(id);
		
		if(!prestataire.isPresent()) {
			throw new PrestataireNotFoundException(String.format("Prestataire avec le id %s introuvable" + id));
		}
			
		return this.prestataireRepository.findById(id);
	}
	//Mettre à jour un prestataire
	public Prestataire updatePrestataire(Prestataire prestataire , Long id) {
		
		Optional<Prestataire> prestataireExist = this.prestataireRepository.findById(id);
		
		if(!prestataireExist.isPresent()) {
			throw new PrestataireNotFoundException(String.format("Prestataire avec le id %s introuvable" + id));
			
		}
		return this.prestataireRepository.save(prestataire);
	}
	//Supprimer un prestataire
	public void removePrestataire(Long id) {
Optional<Prestataire> prestataire = this.prestataireRepository.findById(id);
		
		if(!prestataire.isPresent()) {
			throw new PrestataireNotFoundException(String.format("Prestataire avec le id %s introuvable" + id));
		}
		
	}
}
