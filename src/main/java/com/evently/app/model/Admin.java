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

public class Admin extends Utilisateur{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdmin")
	private long id;
	private String photoAdmin;

	 @ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;


	public String getPhotoAdmin() {
		return photoAdmin;
	}

	public void setPhotoAdmin(String photoAdmin) {
		this.photoAdmin = photoAdmin;
	}
}

/*
package com.evently.app.model;

import com.evently.app.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin extends User {
	private String photoAdmin;

	@OneToMany(mappedBy = "admin")
	private List<User> users;
}
*/