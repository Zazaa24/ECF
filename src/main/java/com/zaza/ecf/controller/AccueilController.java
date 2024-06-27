package com.zaza.ecf.controller;

import com.zaza.ecf.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccueilController {

    @Autowired
    public UtilisateurService utilisateurservice;

    @GetMapping("/acceuil")
    public String accueil(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("utilisateurs", utilisateurservice.recupererListeUtilisateur().get(0));
        return "accueil";
    }

}
