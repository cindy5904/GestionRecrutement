package com.example.GestionRecrutement.controller;

import com.example.GestionRecrutement.entity.Candidat;
import com.example.GestionRecrutement.entity.Entretien;
import com.example.GestionRecrutement.entity.OffreEmploi;
import com.example.GestionRecrutement.service.CandidatService;
import com.example.GestionRecrutement.service.EntretienService;
import com.example.GestionRecrutement.service.OffreEmploiService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class CandidatController {
    @Autowired
    private final CandidatService candidatService;
    @Autowired
    private final OffreEmploiService offreEmploiService;
    @Autowired
    private final EntretienService entretienService;

    public CandidatController(CandidatService candidatService, OffreEmploiService offreEmploiService, EntretienService entretienService) {
        this.candidatService = candidatService;
        this.offreEmploiService = offreEmploiService;
        this.entretienService = entretienService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/addForm")
    public String addForm(Model model) {
        model.addAttribute("candidat", new Candidat());
        model.addAttribute("offresEmploi", offreEmploiService.getAll());
        return "addCandidat";
    }

    @PostMapping("/addCandidat")
    public String addCandidat(@ModelAttribute("candidat") Candidat candidat,
                              @RequestParam("offreEmploiId") Long offreEmploiId) {

        OffreEmploi offreEmploi = offreEmploiService.getById(offreEmploiId);

        candidat.setOffreEmploi(offreEmploi);
        candidatService.add(candidat);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("candidatId") Long id) {
        Candidat candidat = candidatService.getById(id);
        if (candidat != null) {
            candidatService.delete(id);
            ;
        }
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("candidats", candidatService.getAll());
        return "list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model){
        Candidat candidat = candidatService.getById(id);
        model.addAttribute("candidat", candidat);
        model.addAttribute("offresEmploi", offreEmploiService.getAll());
        return "addCandidat";
    }

    @GetMapping("/candidats/{id}")
    public String viewCandidat(@PathVariable("id") Long id, Model model) {
        Candidat candidat = candidatService.getById(id);
        model.addAttribute("candidat", candidat);
        model.addAttribute("entretiens", candidat.getEntretiens());
        return "detailCandidat";
    }

}
