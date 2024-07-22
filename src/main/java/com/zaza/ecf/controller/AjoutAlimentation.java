package com.zaza.ecf.controller;


import com.zaza.ecf.model.Alimentation;

import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.AlimentationService;
import com.zaza.ecf.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutAlimentation {

    @Autowired
    public AnimalService animalService;

    @Autowired
    public AlimentationService alimentationService;


    @GetMapping("/ajout-alimentation")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYE')")
    public String ajoutAlimentation(Model model) {
        Alimentation nouvelAlimentation = new Alimentation();
        model.addAttribute("nouvelAlimentation", nouvelAlimentation);
        model.addAttribute("listeAnimal", animalService.recupererListeAnimal());
        return "ajout-alimentation";
    }

    @PostMapping("/creerAlimentationModel")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYE')")
    public String creerAlimentation(@ModelAttribute("nouvelAlimentation") Alimentation alimentation) {
        Utilisateur defaultUtilisateur = new Utilisateur();
        defaultUtilisateur.setId(1L);
        alimentation.setUtilisateur(defaultUtilisateur);
        alimentationService.creerAlimentation(alimentation);
        return "redirect:ajout-alimentation";
    }
}
