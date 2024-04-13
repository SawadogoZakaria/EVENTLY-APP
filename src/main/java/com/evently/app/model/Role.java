package com.evently.app.model;
import com.evently.app.role.TypeDeRole;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Enumerated(EnumType.STRING)
    private TypeDeRole libelle;

    public TypeDeRole getLibelle() {
        return libelle;
    }

    public void setLibelle(TypeDeRole libelle) {
        this.libelle = libelle;
    }
}
