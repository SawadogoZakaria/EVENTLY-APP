package com.evently.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class  Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  long id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "mot_de_passe")
    private  String mdp;
    private  String nom;
    @OneToMany(mappedBy = "utilisateur")
    private List<Client> clients;

    @OneToMany(mappedBy = "utilisateur")
    private List<Prestataire> prestataires;

    @OneToMany(mappedBy = "utilisateur")
    private List<Admin> admins;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private  String email;

    public String getMdp() {
        return mdp;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Prestataire> getPrestataires() {
        return prestataires;
    }

    public void setPrestataires(List<Prestataire> prestataires) {
        this.prestataires = prestataires;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private  boolean actif = false;
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority( "ROLE_" +this.role.getLibelle())) ;
    }

    @Override
    public String getPassword() {
        return this.mdp;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isEnabled() {
        return this.actif;
    }


}
