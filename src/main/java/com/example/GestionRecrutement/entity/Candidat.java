package com.example.GestionRecrutement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String dateNaissance;

    @ManyToOne
    @JoinColumn(name = "offre_emploi_id")
    private OffreEmploi offreEmploi;

    @OneToMany(mappedBy = "candidat")
    private List<Entretien> entretiens;

}
