package com.evently.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evently.app.model.Paiement;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
