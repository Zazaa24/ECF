package com.zaza.ecf.controller;



import com.zaza.ecf.model.RapportVeterinaire;
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

    @GetMapping("/ajout-rapport")
    public String ajoutRapport(Model model) {
        RapportVeterinaire nouveauxRapport =new RapportVeterinaire();
        model.addAttribute("nouveauxRapport", nouveauxRapport);
        model.addAttribute("listeAnimal", animalService.recupererListeAnimal());
        return "ajout-rapport";
    }

    @PostMapping("/creerRapportModel")
    public String creerAlimentation(@ModelAttribute("nouvelAlimentation") RapportVeterinaire rapportVeterinaire) {
        rapportVeterinaireService.creerRapportVeterinaire(rapportVeterinaire);
        return "redirect:ajout-rapport";
    }
}
