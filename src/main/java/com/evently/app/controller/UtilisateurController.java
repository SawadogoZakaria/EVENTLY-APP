package com.evently.app.controller;


import com.evently.app.dto.AuthentificationDTO;
import com.evently.app.model.Admin;
import com.evently.app.model.Client;
import com.evently.app.model.Prestataire;
import com.evently.app.model.Utilisateur;
import com.evently.app.security.JwtService;
import com.evently.app.service.AdminService;
import com.evently.app.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@EnableMethodSecurity
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateurController {

    private AuthenticationManager authenticationManager;
    private UtilisateurService utilisateurService;
    private JwtService jwtService;
   // @PreAuthorize("hasAnyAuthority(ADMINISTRATEUR.name(), UTILISATEUR.name())")
    @PostMapping(path = "inscription")
    public void inscription(@RequestBody Utilisateur utilisateur) {
       // log.info("Inscription");
        this.utilisateurService.inscription(utilisateur);
    }
    @PostMapping(name="create", path = "/api/v1/rest/clients/inscription")
    @ResponseStatus(HttpStatus.CREATED)
    public void add (@RequestBody Client client) {
        this.utilisateurService.inscriptionClient(client);
    }
    @PostMapping(name="create", path = "/api/v1/rest/prestataires/inscription")
    @ResponseStatus(HttpStatus.CREATED)
    public void add (@RequestBody Prestataire prestataire) {
        this.utilisateurService.inscriptionPrestataire(prestataire);
    }
    @PostMapping(name="create", path = "/api/v1/rest/admins/inscription")
    @ResponseStatus(HttpStatus.CREATED)
    public void add (@RequestBody Admin admin) {
        this.utilisateurService.inscriptionAdministrateur(admin);
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.utilisateurService.activation(activation);
    }
    @PostMapping(path = "modifier-mot-de-passe")
    public void modifierMotDePasse(@RequestBody Map<String, String> activation) {
        this.utilisateurService.modifierMotDePasse(activation);
    }

    @PostMapping(path = "nouveau-mot-de-passe")
    public void nouveauMotDePasse(@RequestBody Map<String, String> activation) {
        this.utilisateurService.nouveauMotDePasse(activation);
    }

    @PostMapping(path = "refresh-token")
    public @ResponseBody Map<String, String> refreshToken(@RequestBody Map<String, String> refreshTokenRequest) {
        return this.jwtService.refreshToken(refreshTokenRequest);
    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );

        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }
        return null;
    }
    @PostMapping(path = "deconnexion")
    public  void  deconnexion(){
        this.jwtService.deconnexion();
    }
}
