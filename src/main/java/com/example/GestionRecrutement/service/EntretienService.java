package com.example.GestionRecrutement.service;

import com.example.GestionRecrutement.entity.Entretien;
import com.example.GestionRecrutement.repository.EntretienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntretienService implements IService<Entretien> {
    @Autowired
    private final EntretienRepository entretienRepository;

    public EntretienService(EntretienRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

    @Override
    public List<Entretien> getAll() {
        return entretienRepository.findAll();
    }

    @Override
    public Entretien getById(Long id) {
        return entretienRepository.findById(id).orElse(null);
    }

    @Override
    public Entretien add(Entretien element) {
        return entretienRepository.save(element);
    }

    @Override
    public void delete(Long id) {
        entretienRepository.deleteById(id);
    }

    @Override
    public Entretien update(Entretien element) {
        return entretienRepository.save(element);
    }
}
