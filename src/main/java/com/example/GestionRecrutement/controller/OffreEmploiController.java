package com.example.GestionRecrutement.controller;

import com.example.GestionRecrutement.entity.OffreEmploi;
import com.example.GestionRecrutement.service.OffreEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OffreEmploiController {
    @Autowired
    private OffreEmploiService offreEmploiService;

    public OffreEmploiController(OffreEmploiService offreEmploiService) {
        this.offreEmploiService = offreEmploiService;
    }

    @GetMapping("/listOffresEmploi")
    public String listOffres(Model model) {
        model.addAttribute("offres", offreEmploiService.getAll());
        return "listOffresEmploi";
    }

    @GetMapping("/addFormOffreEmploi")
    public String addForm(Model model) {
        model.addAttribute("offreEmploi", new OffreEmploi());
        return "addOffreEmploi";
    }

    @PostMapping("/addOffreEmploi")
    public String addOffre(@ModelAttribute("offreEmploi") OffreEmploi offreEmploi) {
        offreEmploiService.add(offreEmploi);
        return "redirect:/listOffresEmploi";
    }

    @GetMapping("/deleteOffreEmploi")
    public String deleteOffre(@RequestParam("id") Long id) {
        OffreEmploi offreEmploi = offreEmploiService.getById(id);
        if (offreEmploi != null) {
            offreEmploiService.delete(id);
        }
        return "redirect:/listOffresEmploi";
    }

    @GetMapping("/updateOffreEmploi")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        OffreEmploi offreEmploi = offreEmploiService.getById(id);
        model.addAttribute("offreEmploi", offreEmploi);
        return "addOffreEmploi";
    }


}
