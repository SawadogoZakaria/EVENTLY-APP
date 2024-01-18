package com.evently.app.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Organisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOrganisateur")
	
	
	private long idOrganisateur;
	private String nomOrganisateur;
	private String prenomOrganisateur;
	private char domicileOrganisateur;
	private Date dNaissanceOrganisateur;
	private String passwordOrganisateur;
	private String photoOrganisateur;
	private char mailOrganisateur;
	private int numeroOrganisateur;
	
	

}
