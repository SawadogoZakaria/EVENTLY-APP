package com.evently.app.repository;

import com.evently.app.model.Prestataire;
import com.evently.app.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evently.app.model.Admin;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
@Transactional


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);

}
