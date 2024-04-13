package com.evently.app.repository;

import com.evently.app.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evently.app.model.Client;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
@Transactional

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
}
