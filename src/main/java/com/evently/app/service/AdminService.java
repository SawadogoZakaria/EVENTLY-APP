package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.AdminNotFoundException;
import com.evently.app.model.Admin;
import com.evently.app.repository.AdminRepository;

@Service 
public class AdminService {
	private AdminRepository adminRepository;
	
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	//Ajout d'un admin
	
	public Admin saveAdmin(Admin admin) {
		return this.adminRepository.save(admin);
	}
	//afficher la liste des admins
	public List<Admin>getAllAdmins(){
		
		return this.adminRepository.findAll();
	}
	//Afficher les details d'un admins
	public Optional<Admin>getOneAdmin(Long id){
		
Optional<Admin> admin = this.adminRepository.findById(id);
		
		if(!admin.isPresent()) {
			throw new AdminNotFoundException(String.format("Admin avec le id %s introuvable" + id));
		}
			
		return this.adminRepository.findById(id);
	}
	//Mettre à jour un admin
	public Admin updateAdmin(Admin admin , Long id) {
		
		Optional<Admin> adminExist = this.adminRepository.findById(id);
		
		if(!adminExist.isPresent()) {
			throw new AdminNotFoundException(String.format("Admin avec le id %s introuvable" + id));
			
		}
		return this.adminRepository.save(admin);
	}
	//Supprimer un admin
	public void removeAdmin(Long id) {
Optional<Admin> admin = this.adminRepository.findById(id);
		
		if(!admin.isPresent()) {
			throw new AdminNotFoundException(String.format("Admin avec le id %s introuvable" + id));
		}
		
	}
}
