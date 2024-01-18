package com.evently.app.model;

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
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTicket")
	
	private long idTicket;
	public long getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}
	public String getDenominationTicket() {
		return denominationTicket;
	}
	public void setDenominationTicket(String denominationTicket) {
		this.denominationTicket = denominationTicket;
	}
	public int getPrixTicket() {
		return prixTicket;
	}
	public void setPrixTicket(char prixTicket) {
		this.prixTicket = prixTicket;
	}
	public int getNumeroicket() {
		return numeroTicket;
	}
	public void setNumeroicket(int numeroicket) {
		this.numeroTicket = numeroicket;
	}
	private String denominationTicket;
	private int prixTicket;
	private int numeroTicket;
	

	
}
