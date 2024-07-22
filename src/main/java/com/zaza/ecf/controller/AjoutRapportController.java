package com.zaza.ecf.controller;



import com.zaza.ecf.model.Alimentation;
import com.zaza.ecf.model.Animal;
import com.zaza.ecf.model.RapportVeterinaire;
import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.AlimentationService;
import com.zaza.ecf.service.AnimalService;
import com.zaza.ecf.service.RapportVeterinaireService;
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
public class AjoutRapportController {
    @Autowired
    public UtilisateurService utilisateurService;
    @Autowired
    public AnimalService animalService;
    @Autowired
    public RapportVeterinaireService rapportVeterinaireService;
    @Autowired
    public AlimentationService alimentationService;

    @GetMapping("/ajout-rapport")
    @PreAuthorize("hasAuthority('ROLE_VETERINAIRE')")
    public String ajoutRapport(@RequestParam(name="etat", required = false) String etat, Model model) {
        model.addAttribute("etat", etat);
        RapportVeterinaire nouveauxRapport =new RapportVeterinaire();
        Alimentation nouvelAlimentation = new Alimentation();
        nouveauxRapport.setAlimentation(nouvelAlimentation);
        model.addAttribute("nouveauxRapport", nouveauxRapport);
        model.addAttribute("listeAnimal", animalService.recupererListeAnimal());
        return "ajout-rapport";
    }

    @PostMapping("/creerRapportModel")
    @PreAuthorize("hasAuthority('ROLE_VETERINAIRE')")
    public String creerNouveauxRapport(@ModelAttribute("nouveauxRapport") RapportVeterinaire rapportVeterinaire, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userDetails.getUsername();
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.recupererUtilisateurParUsername(userDetails.getUsername());
        if(optionalUtilisateur.isPresent()) {
            rapportVeterinaire.setUtilisateur(optionalUtilisateur.get());
            rapportVeterinaire.getAlimentation().setUtilisateur(optionalUtilisateur.get());
        }
        rapportVeterinaire.getAlimentation().setAnimal(rapportVeterinaire.getAnimal());
        rapportVeterinaire.getAlimentation().setDate(rapportVeterinaire.getDate());
        rapportVeterinaire.getAlimentation().setTime(rapportVeterinaire.getTime());
        alimentationService.creerAlimentation(rapportVeterinaire.getAlimentation());
        rapportVeterinaireService.creerRapportVeterinaire(rapportVeterinaire);
        Optional<Animal> optionalAnimal = animalService.recupererAnimalParId(rapportVeterinaire.getAnimal().getId());
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.setEtat(rapportVeterinaire.getDetail());
            animalService.modifierAnimal(animal);
        }
        return "redirect:ajout-rapport?etat=success";
    }
}
