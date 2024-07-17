package com.zaza.ecf.controller;


import com.zaza.ecf.model.Race;
import com.zaza.ecf.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GestionRaceController {

    @Autowired
    public RaceService raceService;

    @GetMapping("/gestion-races")
    public String RaceController(Model model) {
        model.addAttribute("listeRace",raceService.recupererListeRace());
        Race nouvelRace = new Race();
        model.addAttribute("nouvelRace", nouvelRace);
        return "gestion-races";
    }

    @PostMapping("/creerRaceModel")
    public String creerRace(@ModelAttribute("nouvelRace") Race race) {
        raceService.creerRace(race);
        return "redirect:gestion-races";
    }

    @PostMapping("/modifierRaceModel/{id}")
    public String  modifierRace(@PathVariable Long id, @ModelAttribute Race race) {
        raceService.modifierRace((race));
        return "redirect:../gestion-races";
    }

    @GetMapping("/supprimerRaceModel/{id}")
    public String supprimerRace(@PathVariable Long id) {
        raceService.supprimerRace(id);
        return "redirect:../gestion-races";
    }
}
