package com.example.GestionRecrutement.controller;

import com.example.GestionRecrutement.entity.Candidat;
import com.example.GestionRecrutement.entity.Entretien;
import com.example.GestionRecrutement.entity.OffreEmploi;
import com.example.GestionRecrutement.service.CandidatService;
import com.example.GestionRecrutement.service.EntretienService;
import com.example.GestionRecrutement.service.OffreEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EntretienController {
    @Autowired
    private EntretienService entretienService;

    @Autowired
    private CandidatService candidatService;
    @Autowired
    private OffreEmploiService offreEmploiService;

    public EntretienController(EntretienService entretienService, CandidatService candidatService, OffreEmploiService offreEmploiService) {
        this.entretienService = entretienService;
        this.candidatService = candidatService;
        this.offreEmploiService = offreEmploiService;
    }

    @GetMapping("/addFormEntretien")
    public String addForm(@RequestParam("candidatId") Long candidatId,
                          @RequestParam("offreEmploiId") Long offreEmploiId,
                          Model model) {
        Entretien entretien = new Entretien();


        Candidat candidat = candidatService.getById(candidatId);
        entretien.setCandidat(candidat);

        OffreEmploi offreEmploi = offreEmploiService.getById(offreEmploiId);
        entretien.setOffreEmploi(offreEmploi);

        model.addAttribute("entretien", entretien);
        return "addEntretien";
    }

    @PostMapping("/addEntretien")
    public String addEntretien(@ModelAttribute("entretien") Entretien entretien) {
        entretienService.add(entretien);
        return "redirect:/candidats/" + entretien.getCandidat().getId();
    }

    @GetMapping("/deleteEntretien")
    public String delete(@RequestParam("id") Long id) {
        Entretien entretien = entretienService.getById(id);
        if (entretien != null) {
            entretienService.delete(id);
        }
        return "redirect:/listEntretien" + entretien.getCandidat().getId();
    }

    @GetMapping("/updateEntretien")
    public String update(@RequestParam("id") Long id, Model model) {
        Entretien entretien = entretienService.getById(id);
        model.addAttribute("entretien", entretien);
        return "addEntretien";
    }

    @GetMapping("/listEntretien")
    public String list(Model model) {
        model.addAttribute("entretiens", entretienService.getAll());
        return "listEntretien";
    }

}
