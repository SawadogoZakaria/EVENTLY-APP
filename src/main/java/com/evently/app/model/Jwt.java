package com.evently.app.model;


import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jwt")
public class Jwt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String valeur;
    private boolean desactive;
    private boolean expire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public boolean isDesactive() {
        return desactive;
    }

    public void setDesactive(boolean desactive) {
        this.desactive = desactive;
    }

    public boolean isExpire() {
        return expire;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private RefreshToken refreshToken;


}