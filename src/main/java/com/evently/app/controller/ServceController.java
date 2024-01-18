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

import com.evently.app.model.Servce;
import com.evently.app.service.ServceService;

@RestController
@RequestMapping(path="/api/v1/rest" , name = "evently_app")

public class ServceController {
	private ServceService servceService;
	
	@Autowired
	public ServceController(ServceService servceService) {
		this.servceService = servceService;
	}
	@PostMapping(path = "/services", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Servce add (@RequestBody Servce servce) {
		return this.servceService.saveServce(servce);
	}
	
	@GetMapping(path = "/services",name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Servce> list(){
		return this.servceService.getAllServces();
		 
	}
	@GetMapping(path = "/services/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Servce> read(@PathVariable Long id){
		return this.servceService.getOneServce(id);
	}
	
	@PutMapping(path = "/services/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Servce update (@RequestBody Servce servce , @PathVariable Long id) {
		return this.servceService.updateServce(servce, id);
	}
	@DeleteMapping(path = "/services/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.servceService.removeServce(id);
	}
}
