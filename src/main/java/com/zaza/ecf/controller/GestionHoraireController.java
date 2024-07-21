package com.zaza.ecf.controller;



import com.zaza.ecf.model.Horaire;
import com.zaza.ecf.service.HoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GestionHoraireController {

    @Autowired
    public HoraireService horaireService;

    @GetMapping("/gestion-horaires")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String gestionHoraire(Model model) {
        model.addAttribute("listeHoraire",horaireService.recupererListeHoraire());
        Horaire nouvelHoraire = new Horaire();
        model.addAttribute("nouvelHoraire", nouvelHoraire);
        return "gestion-horaires";
    }

    @PostMapping("/creerHoraireModel")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String creerHoraire(@ModelAttribute("nouvelHoraire")Horaire horaire) {
        horaireService.creerHoraire(horaire);
        return "redirect:gestion-horaires";
    }

    @PostMapping("/modifierHoraireModel/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String  modifierHoraire(@PathVariable Long id, @ModelAttribute Horaire horaire) {
        horaireService.modifierHoraire((horaire));
        return "redirect:../gestion-horaires";
    }

    @GetMapping("/supprimerHoraireModel/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String supprimerHoraire(@PathVariable Long id) {
        horaireService.supprimerHoraire(id);
        return "redirect:../gestion-horaires";
    }


}
