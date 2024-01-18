package com.evently.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evently.app.exception.TicketNotFoundException;
import com.evently.app.model.Ticket;
import com.evently.app.repository.TicketRepository;

@Service 
public class TicketService {
	private TicketRepository ticketRepository;
	
	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	//Ajout d'un ticket
	
	public Ticket saveTicket(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}
	//afficher la liste des tickets
	public List<Ticket>getAllTickets(){
		
		return this.ticketRepository.findAll();
	}
	//Afficher les details d'un tickets
	public Optional<Ticket>getOneTicket(Long id){
		
Optional<Ticket> ticket = this.ticketRepository.findById(id);
		
		if(!ticket.isPresent()) {
			throw new TicketNotFoundException(String.format("Ticket avec le id %s introuvable" + id));
		}
			
		return this.ticketRepository.findById(id);
	}
	//Mettre à jour un ticket
	public Ticket updateTicket(Ticket ticket , Long id) {
		
		Optional<Ticket> ticketExist = this.ticketRepository.findById(id);
		
		if(!ticketExist.isPresent()) {
			throw new TicketNotFoundException(String.format("Ticket avec le id %s introuvable" + id));
			
		}
		return this.ticketRepository.save(ticket);
	}
	//Supprimer un ticket
	public void removeTicket(Long id) {
Optional<Ticket> ticket = this.ticketRepository.findById(id);
		
		if(!ticket.isPresent()) {
			throw new TicketNotFoundException(String.format("Ticket avec le id {id} introuvable" + id));
		}
		this.ticketRepository.delete(ticket.get());
		
	}
}
