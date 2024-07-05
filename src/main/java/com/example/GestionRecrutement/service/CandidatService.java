package com.example.GestionRecrutement.service;

import com.example.GestionRecrutement.entity.Candidat;
import com.example.GestionRecrutement.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService implements IService<Candidat>{
    @Autowired
    private final CandidatRepository candidatRepository;

    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public List<Candidat> getAll() {
        return candidatRepository.findAll();
    }

    @Override
    public Candidat getById(Long id) {
        return candidatRepository.findById(id).orElse(null);
    }

    @Override
    public Candidat add(Candidat element) {
        return candidatRepository.save(element);
    }

    @Override
    public void delete(Long id) {
        candidatRepository.deleteById(id);
    }

    @Override
    public Candidat update(Candidat element) {
        return candidatRepository.save(element);
    }
}
