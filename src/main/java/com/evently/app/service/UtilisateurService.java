package com.evently.app.service;

import com.evently.app.model.*;
import com.evently.app.repository.UtilisateurRepository;
import com.evently.app.role.TypeDeRole;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@Service
@Primary
@AllArgsConstructor
public class UtilisateurService implements UserDetailsService {
    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private  ValidationService validationService;

    //INSCRIPTION DE ROLE UTILISATEUR
    public void inscription(Utilisateur utilisateur){
        /*
        if (!utilisateur.getEmail().contains("@")) {
            throw new RuntimeException("Votre mail invalide");
        }
        if (!utilisateur.getEmail().contains(".")) {
            throw new RuntimeException("Votre mail invalide");
        }

        final Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()) {
            throw new RuntimeException("Votre mail est déjà utilisé");
        }
        final String mdpCrypte = this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpCrypte);

        final Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        if (utilisateur.getRole() != null && utilisateur.getRole().getLibelle().equals(TypeDeRole.ADMINISTRATEUR)) {
            roleUtilisateur.setLibelle(TypeDeRole.ADMINISTRATEUR);
            utilisateur.setActif(true);
        }
        utilisateur.setRole(roleUtilisateur);

        utilisateur = this.utilisateurRepository.save(utilisateur);

        if (roleUtilisateur.getLibelle().equals(TypeDeRole.UTILISATEUR)) {
            this.validationService.enregistrer(utilisateur);
        }
         */

        if(!utilisateur.getEmail().contains("@")){
            throw  new RuntimeException("Votre email est invalide");
        }
        if(!utilisateur.getEmail().contains(".")){
            throw  new RuntimeException("Votre email est invalide");
        }
        Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
            if(utilisateurOptional.isPresent()){
                throw new RuntimeException("Votre mail est dejà utilisé");
            }
        String mdpCrypter = this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpCrypter);
        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        utilisateur.setRole(roleUtilisateur);
        utilisateur = this.utilisateurRepository.save(utilisateur);
        this.validationService.enregistrer(utilisateur);


    }
    // INSCRIPTION D'UN ADMIN
    public void inscriptionAdmin(Utilisateur utilisateur){
        /*
        if (!utilisateur.getEmail().contains("@")) {
            throw new RuntimeException("Votre mail invalide");
        }
        if (!utilisateur.getEmail().contains(".")) {
            throw new RuntimeException("Votre mail invalide");
        }

        final Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()) {
            throw new RuntimeException("Votre mail est déjà utilisé");
        }
        final String mdpCrypte = this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpCrypte);

        final Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.ADMINISTRATEUR);
        if (utilisateur.getRole() != null && utilisateur.getRole().getLibelle().equals(TypeDeRole.ADMINISTRATEUR)) {
            roleUtilisateur.setLibelle(TypeDeRole.ADMINISTRATEUR);
            utilisateur.setActif(true);
        }
        utilisateur.setRole(roleUtilisateur);

        utilisateur = this.utilisateurRepository.save(utilisateur);

        if (roleUtilisateur.getLibelle().equals(TypeDeRole.UTILISATEUR)) {
            this.validationService.enregistrer(utilisateur);
        }
        */
        if(!utilisateur.getEmail().contains("@")){
            throw  new RuntimeException("Votre email est invalide");
        }
        if(!utilisateur.getEmail().contains(".")){
            throw  new RuntimeException("Votre email est invalide");
        }
        final Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if(utilisateurOptional.isPresent()){
            throw new RuntimeException("Votre mail est dejà utilisé");
        }
       final String mdpCrypte = this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpCrypte);
        final Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.ADMINISTRATEUR);
        utilisateur.setRole(roleUtilisateur);
        utilisateur = this.utilisateurRepository.save(utilisateur);
        this.validationService.enregistrer(utilisateur);


    }

    //INSCRIPTION CLIENT
    public void inscriptionClient(Client client) {
        inscription(client);
    }
    //INSCIPTION  D'UN PRESTATAIRE
    public void inscriptionPrestataire(Prestataire prestataire) {
        inscription(prestataire);
    }
    //INSCRIPTION D'UN ADMIN
    public void inscriptionAdministrateur(Admin admin) {
        inscriptionAdmin(admin);
    }


    public void activation(final Map<String, String> activation) {
       final Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw new RuntimeException("Votre code a expiré");
        }
       final Utilisateur utilisateurActiver = this.utilisateurRepository.findById(validation.getUtilisateur().getId()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        utilisateurActiver.setActif(true);
        this.utilisateurRepository.save(utilisateurActiver);
    }

    @Override
    public Utilisateur loadUserByUsername(final String username) throws UsernameNotFoundException {
      return this.utilisateurRepository
              .findByEmail(username)
              .orElseThrow(() ->new  UsernameNotFoundException("Aucun utilisateur ne correstpond à ce identifiant"));

    }

    public void modifierMotDePasse(Map<String, String> parametres) {
        Utilisateur utilisateur =  this.loadUserByUsername(parametres.get("email"));
        this.validationService.enregistrer(utilisateur);
    }

    public void nouveauMotDePasse(Map<String, String> parametres) {
        Utilisateur utilisateur = (Utilisateur) this.loadUserByUsername(parametres.get("email"));
        final Validation validation =  validationService.lireEnFonctionDuCode(parametres.get("code"));
        if (validation.getUtilisateur().getEmail().equals(utilisateur.getEmail())){
            String mdpCrypte = this.passwordEncoder.encode(parametres.get("password"));
            utilisateur.setMdp(mdpCrypte);
            this.utilisateurRepository.save(utilisateur);
        }

    }

}
