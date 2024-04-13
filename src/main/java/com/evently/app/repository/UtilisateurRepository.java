package com.evently.app.repository;

import com.evently.app.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    Optional<Utilisateur>findByEmail(String email);
}
