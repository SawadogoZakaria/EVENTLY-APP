package com.evently.app.repository;

import com.evently.app.model.Utilisateur;
import com.evently.app.model.Validation;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.Optional;

public interface ValidationRepository extends CrudRepository<Validation, Integer> {
    public Optional<Validation> findByUtilisateur(Utilisateur utilisateur);

    Optional<Validation> findByCode(String code);

    void deleteAllByExpirationBefore(Instant now);
}