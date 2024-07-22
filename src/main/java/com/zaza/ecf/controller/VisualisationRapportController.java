package com.zaza.ecf.controller;

import com.zaza.ecf.service.AnimalService;
import com.zaza.ecf.service.RapportVeterinaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisualisationRapportController {

    @Autowired
    public RapportVeterinaireService rapportVeterinaireService;
    @Autowired
    public AnimalService animalService;

    @GetMapping("/visualisation-rapports")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String visualisationRapport(Model model) {
        model.addAttribute("listeRapport",rapportVeterinaireService.recupererListeRapportVeterinaire());
        model.addAttribute("listeAnimal", animalService.recupererListeAnimal());
        return "visualisation-rapports";
    }
}
