package com.evently.app.repository;

import com.evently.app.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evently.app.model.Prestataire;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
@Transactional

public interface PrestataireRepository extends JpaRepository<Prestataire, Long>{
    Optional<Prestataire> findByEmail(String email);


}
