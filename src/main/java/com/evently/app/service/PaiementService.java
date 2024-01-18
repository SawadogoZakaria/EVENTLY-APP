package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.PaiementNotFoundException;
import com.evently.app.model.Paiement;
import com.evently.app.repository.PaiementRepository;

@Service 
public class PaiementService {
	private PaiementRepository paiementRepository;
	
	public PaiementService(PaiementRepository paiementRepository) {
		this.paiementRepository = paiementRepository;
	}
	//Ajout d'un paiement
	
	public Paiement savePaiement(Paiement paiement) {
		return this.paiementRepository.save(paiement);
	}
	//afficher la liste des paiements
	public List<Paiement>getAllPaiements(){
		
		return this.paiementRepository.findAll();
	}
	//Afficher les details d'un paiements
	public Optional<Paiement>getOnePaiement(Long id){
		
Optional<Paiement> paiement = this.paiementRepository.findById(id);
		
		if(!paiement.isPresent()) {
			throw new PaiementNotFoundException(String.format("Paiement avec le id %s introuvable" + id));
		}
			
		return this.paiementRepository.findById(id);
	}
	//Mettre à jour un paiement
	public Paiement updatePaiement(Paiement paiement , Long id) {
		
		Optional<Paiement> paiementExist = this.paiementRepository.findById(id);
		if(!paiementExist.isPresent()) {
			throw new PaiementNotFoundException(String.format("Paiement avec le id %s introuvable" + id));
			
		}
		return this.paiementRepository.save(paiement);
	}
	//Supprimer un paiement
	public void removePaiement(Long id) {
Optional<Paiement> paiement = this.paiementRepository.findById(id);
		
		if(!paiement.isPresent()) {
			throw new PaiementNotFoundException(String.format("Paiement avec le id %s introuvable" + id));
		}
		
	}
}
