package com.evently.app.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table

@EqualsAndHashCode(callSuper = false)
public class Client extends Utilisateur{
	public Date getdNaissanceClient() {
		return dNaissanceClient;
	}

	public void setdNaissanceClient(Date dNaissanceClient) {
		this.dNaissanceClient = dNaissanceClient;
	}

	public String getPhotoClient() {
		return photoClient;
	}

	public void setPhotoClient(String photoClient) {
		this.photoClient = photoClient;
	}

	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public char getDomicileClient() {
		return domicileClient;
	}

	public void setDomicileClient(char domicileClient) {
		this.domicileClient = domicileClient;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private long id;
	

	private Date dNaissanceClient;
	private String photoClient;
	private int numeroClient;
	private char domicileClient;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;


    public void setUtilisateur(Utilisateur utilisateur) {
    }
}
