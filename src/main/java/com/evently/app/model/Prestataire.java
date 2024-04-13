package com.evently.app.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table

@EqualsAndHashCode(callSuper = false)
public class Prestataire extends Utilisateur {

	public String getPhotoPrestataire() {
		return photoPrestataire;
	}

	public void setPhotoPrestataire(String photoPrestataire) {
		this.photoPrestataire = photoPrestataire;
	}

	public int getNumeroPrestataire() {
		return numeroPrestataire;
	}

	public void setNumeroPrestataire(int numeroPrestataire) {
		this.numeroPrestataire = numeroPrestataire;
	}

	public char getDomicilePrestataire() {
		return domicilePrestataire;
	}

	public void setDomicilePrestataire(char domicilePrestataire) {
		this.domicilePrestataire = domicilePrestataire;
	}

	public char getNumroCompteP() {
		return numroCompteP;
	}

	public void setNumroCompteP(char numroCompteP) {
		this.numroCompteP = numroCompteP;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPrestataire")
	private  long id;
	

	private String photoPrestataire;
	private int numeroPrestataire;
	private char domicilePrestataire;
	private char numroCompteP;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;


}
