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
public class Prestataire {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPrestataire")
	
	
	private long idPrestataire;
	private String nomPrestataire;
	private String prenomPrestataire;
	private String passwordClient;
	private Date dNaissancePrestataire;
	private String photoPrestataire;
	private char mailPrestataire;
	private int numeroPrestataire;
	private char domicilePrestataire;
	private char numroCompteP;
	
	

}
