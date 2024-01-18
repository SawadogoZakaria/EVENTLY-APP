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

import com.evently.app.model.Ticket;
import com.evently.app.service.TicketService;

@RestController
@RequestMapping(path="/api/v1/rest" , name = "evently_app")

public class TicketController {
	private TicketService ticketService;
	
	@Autowired
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@PostMapping(path = "/tickets", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket add (@RequestBody Ticket ticket) {
		return this.ticketService.saveTicket(ticket);
	}
	
	/*
	@PostMapping(path = "/tickets", name="create")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket add(@RequestBody Ticket ticket) {
	    System.out.println("Received ticket: " + ticket);
	    Ticket savedTicket = this.ticketService.saveTicket(ticket);
	    System.out.println("Saved ticket: " + savedTicket);
	    return savedTicket;
	}
*/
	
	@GetMapping(path = "/tickets",name = "list")
	@ResponseStatus(HttpStatus.OK)
	public List<Ticket> list(){
		return this.ticketService.getAllTickets();
		 
	}
	@GetMapping(path = "/tickets/{id}", name = "read")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Ticket> read(@PathVariable Long id){
		return this.ticketService.getOneTicket(id);
	}
	
	@PutMapping(path = "/tickets/{id}" , name = "update")
	@ResponseStatus(HttpStatus.OK)
	public Ticket update (@RequestBody Ticket ticket , @PathVariable Long id) {
		return this.ticketService.updateTicket(ticket, id);
	}
	@DeleteMapping(path = "/tickets/{id}" , name = "remove")
	@ResponseStatus(HttpStatus.NO_CONTENT )
	public void remove(@PathVariable Long id) {
		this.ticketService.removeTicket(id);
	}
}
