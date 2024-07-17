package com.zaza.ecf.controller;



import com.zaza.ecf.model.Alimentation;
import com.zaza.ecf.model.RapportVeterinaire;
import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.AlimentationService;
import com.zaza.ecf.service.AnimalService;
import com.zaza.ecf.service.RapportVeterinaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutRapport {

    @Autowired
    public AnimalService animalService;
    @Autowired
    public RapportVeterinaireService rapportVeterinaireService;
    @Autowired
    public AlimentationService alimentationService;

    @GetMapping("/ajout-rapport")
    public String ajoutRapport(Model model) {
        RapportVeterinaire nouveauxRapport =new RapportVeterinaire();
        Alimentation nouvelAlimentation = new Alimentation();
        nouveauxRapport.setAlimentation(nouvelAlimentation);
        model.addAttribute("nouveauxRapport", nouveauxRapport);
        model.addAttribute("listeAnimal", animalService.recupererListeAnimal());
        return "ajout-rapport";
    }

    @PostMapping("/creerRapportModel")
    public String creerNouveauxRapport(@ModelAttribute("nouveauxRapport") RapportVeterinaire rapportVeterinaire) {
        Utilisateur defaultUtilisateur = new Utilisateur();
        defaultUtilisateur.setId(1L);
        rapportVeterinaire.setUtilisateur(defaultUtilisateur);
        rapportVeterinaire.getAlimentation().setUtilisateur(defaultUtilisateur);
        rapportVeterinaire.getAlimentation().setAnimal(rapportVeterinaire.getAnimal());
        rapportVeterinaire.getAlimentation().setDate(rapportVeterinaire.getDate());
        rapportVeterinaire.getAlimentation().setTime(rapportVeterinaire.getTime());
        alimentationService.creerAlimentation(rapportVeterinaire.getAlimentation());
        rapportVeterinaireService.creerRapportVeterinaire(rapportVeterinaire);
        return "redirect:ajout-rapport";
    }
}
