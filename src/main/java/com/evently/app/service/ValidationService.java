package com.evently.app.service;

import com.evently.app.model.Utilisateur;
import com.evently.app.model.Validation;
import com.evently.app.repository.ValidationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@AllArgsConstructor
@Transactional
@Slf4j
@Service
public class ValidationService {

    private  ValidationRepository validationRepository;
    private NotificationService notificationService;
    public void enregistrer(Utilisateur utilisateur) {
        Optional<Validation> optionalValidation = this.validationRepository.findByUtilisateur(utilisateur);
        Validation validation;
        if (optionalValidation.isPresent()) {
            validation = optionalValidation.get();
        } else {
            validation = new Validation();
            validation.setUtilisateur(utilisateur);
        }
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(99999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationService.envoyer(validation);
    }
    /*
    public void enregistrer(Utilisateur utilisateur) {
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        validation.setCreation(creation);

        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);

        Random random = new Random();
        int randomInteger = random.nextInt(99999999);
        String code = String.format("%06d", randomInteger);
        validation.setCode(code);

        this.validationRepository.save(validation);
        this.notificationService.envoyer(validation);
    }
*/
    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }
    @Scheduled(cron = "@daily")
    public void netoyerTable(){
        final  Instant now = Instant.now();
        log.info("suppression de token à {}",now);
        this.validationRepository.deleteAllByExpirationBefore(Instant.now());
    }
}