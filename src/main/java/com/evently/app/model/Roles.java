package com.evently.app.model;

import com.evently.app.enumeration.TypeDeRole;

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
@Entity
@Data
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private TypeDeRole libelle;
	
	public TypeDeRole getLibelle() {
		return libelle;
	}
	public void setLibelle(TypeDeRole libelle) {
		this.libelle = libelle;
	}  


	

}
