package com.example.GestionRecrutement.repository;

import com.example.GestionRecrutement.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
