package com.evently.app.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.evently.app.model.Admin;
import com.evently.app.service.AdminService;

@RestController
@EnableMethodSecurity
@RequestMapping(path="/api/v1/rest" , name = "evently_app")
public class AdminController {
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	/*
	//@PreAuthorize("hasAuthority('ADMINISTRATEUR')")

	@PostMapping( name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Admin add (@RequestBody Admin admin) {
		return this.adminService.saveAdmin(admin);
	}
 */
	//@PreAuthorize("hasAuthority('ADMINISTRATEUR')")
	@Hidden
	@GetMapping(name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Admin> list(){
		return this.adminService.getAllAdmins();
		 
	}
	//@PreAuthorize("hasAuthority('ADMINISTRATEUR')")
	@Hidden
	@GetMapping(path = "/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Admin> read(@PathVariable Long id){
		return this.adminService.getOneAdmin(id);
	}

	//@PreAuthorize("hasAuthority('ADMINISTRATEUR')")
	@Hidden
	@PutMapping(path = "/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Admin update (@RequestBody Admin admin , @PathVariable Long id) {
		return this.adminService.updateAdmin(admin, id);
	}
	//@PreAuthorize("hasAuthority('ADMINISTRATEUR')")
	@Hidden
	@DeleteMapping(path = "/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.adminService.removeAdmin(id);
	}
}
