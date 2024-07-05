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
public class OffreEmploi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String intitule;
    private String description;

    @OneToMany(mappedBy = "offreEmploi")
    private List<Candidat> candidats;

    @OneToMany(mappedBy = "offreEmploi")
    private List<Entretien> entretiens;
}
