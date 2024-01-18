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
@Entity
@Data
public class Servce {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idService")
	private long idService;
	private String nomService;
	private String descriptionService;
	private String cataloguePhoto;

}
