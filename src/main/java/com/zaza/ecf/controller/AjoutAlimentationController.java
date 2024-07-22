package com.zaza.ecf.controller;


import com.zaza.ecf.model.Alimentation;

import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.AlimentationService;
import com.zaza.ecf.service.AnimalService;
import com.zaza.ecf.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AjoutAlimentationController {

    @Autowired
    public AnimalService animalService;
    @Autowired
    public AlimentationService alimentationService;
    @Autowired
    public UtilisateurService utilisateurService;


    @GetMapping("/ajout-alimentation")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYE')")
    public String ajoutAlimentation(@RequestParam(name="etat", required = false) String etat, Model model) {
        model.addAttribute("etat", etat);
        Alimentation nouvelAlimentation = new Alimentation();
        model.addAttribute("nouvelAlimentation", nouvelAlimentation);
        model.addAttribute("listeAnimal", animalService.recupererListeAnimal());
        return "ajout-alimentation";
    }

    @PostMapping("/creerAlimentationModel")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYE')")
    public String creerAlimentation(@ModelAttribute("nouvelAlimentation") Alimentation alimentation, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userDetails.getUsername();
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.recupererUtilisateurParUsername(userDetails.getUsername());
        if(optionalUtilisateur.isPresent()) {
            alimentation.setUtilisateur(optionalUtilisateur.get());
        }
        alimentationService.creerAlimentation(alimentation);
        return "redirect:ajout-alimentation?etat=success";
    }
}
