package com.example.GestionRecrutement.service;

import com.example.GestionRecrutement.entity.OffreEmploi;
import com.example.GestionRecrutement.repository.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreEmploiService implements IService<OffreEmploi> {
    @Autowired
    private final OffreEmploiRepository offreEmploiRepository;

    public OffreEmploiService(OffreEmploiRepository offreEmploiRepository) {
        this.offreEmploiRepository = offreEmploiRepository;
    }


    @Override
    public List<OffreEmploi> getAll() {
        return offreEmploiRepository.findAll();
    }

    @Override
    public OffreEmploi getById(Long id) {
        return offreEmploiRepository.findById(id).orElse(null);
    }

    @Override
    public OffreEmploi add(OffreEmploi element) {
        return offreEmploiRepository.save(element);
    }

    @Override
    public void delete(Long id) {
        offreEmploiRepository.deleteById(id);
    }

    @Override
    public OffreEmploi update(OffreEmploi element) {
        return offreEmploiRepository.save(element);
    }
}
