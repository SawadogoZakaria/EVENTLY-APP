package com.evently.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evently.app.model.Ticket;

import jakarta.transaction.Transactional;

@Repository
@Transactional

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
