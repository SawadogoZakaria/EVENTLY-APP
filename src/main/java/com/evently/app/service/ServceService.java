package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.ServceNotFoundException;
import com.evently.app.model.Servce;
import com.evently.app.repository.ServceRepository;

@Service 
public class ServceService {
	private ServceRepository servceRepository;
	
	public ServceService(ServceRepository servceRepository) {
		this.servceRepository = servceRepository;
	}
	//Ajout d'un servce
	
	public Servce saveServce(Servce servce) {
		return this.servceRepository.save(servce);
	}
	//afficher la liste des servces
	public List<Servce>getAllServces(){
		
		return this.servceRepository.findAll();
	}
	//Afficher les details d'un servces
	public Optional<Servce>getOneServce(Long id){
		
Optional<Servce> servce = this.servceRepository.findById(id);
		
		if(!servce.isPresent()) {
			throw new ServceNotFoundException(String.format("Servce avec le id %s introuvable" + id));
		}
			
		return this.servceRepository.findById(id);
	}
	//Mettre à jour un servce
	public Servce updateServce(Servce servce , Long id) {
		
		Optional<Servce> servceExist = this.servceRepository.findById(id);
		if(!servceExist.isPresent()) {
			throw new ServceNotFoundException(String.format("Servce avec le id %s introuvable" + id));
			
		}
		return this.servceRepository.save(servce);
	}
	//Supprimer un servce
	public void removeServce(Long id) {
Optional<Servce> servce = this.servceRepository.findById(id);
		
		if(!servce.isPresent()) {
			throw new ServceNotFoundException(String.format("Servce avec le id %s introuvable" + id));
		}
		
	}
}
