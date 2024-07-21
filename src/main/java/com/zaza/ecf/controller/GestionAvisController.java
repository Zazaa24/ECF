package com.zaza.ecf.controller;

import com.zaza.ecf.model.Avis;
import com.zaza.ecf.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionAvisController {

    @Autowired
    public AvisService avisService;

    @GetMapping("/gestion-avis")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYE')")
    public String gestionAvis(Model model) {
        model.addAttribute("listeAvis",avisService.recupererListeAvis());
        Avis nouvelAvis = new Avis();
        model.addAttribute("nouvelAvis", nouvelAvis);
        return "gestion-avis";
    }

}
