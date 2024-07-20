package com.zaza.ecf.controller;

import com.zaza.ecf.model.Avis;
import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccueilController {

    @Autowired
    public UtilisateurService utilisateurservice;
    @Autowired
    public AvisService avisService;
    @Autowired
    public ServiceService serviceService;
    @Autowired
    public HabitatService habitatService;
    @Autowired
    public HoraireService horaireService;


    @GetMapping("/accueil")
    public String accueil(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, Authentication authentication) {
        model.addAttribute("listeAvis", avisService.recupererListeAvisParVisible(true));
        model.addAttribute("listeService", serviceService.recupererListeService());
        model.addAttribute("listeHabitat", habitatService.recupererListeHabitat());
        model.addAttribute("listeHoraire",horaireService.recupererListeHoraire());
        model.addAttribute("nouvelAvis", new Avis());
        /*UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getAuthorities().iterator().next().getAuthority());*/
        return "accueil";
    }

    @PostMapping("/creerAvisModel")
    public String creerAvis(@ModelAttribute("nouvelAvis") Avis avis) {
        avis.setEstVisible(false);
        avisService.creerAvis(avis);
        return "redirect:accueil";
    }



}
