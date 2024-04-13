package com.evently.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Validation {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getCreation() {
        return creation;
    }

    public void setCreation(Instant creation) {
        this.creation = creation;
    }

    public Instant getExpiration() {
        return expiration;
    }

    public void setExpiration(Instant expiration) {
        this.expiration = expiration;
    }

    public Instant getActivation() {
        return activation;
    }

    public void setActivation(Instant activation) {
        this.activation = activation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private Instant creation;
    private Instant expiration;
    private  Instant activation;
    private String code;
    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.DETACH})
    private  Utilisateur utilisateur;
}
