package com.zaza.ecf.controller;


import com.zaza.ecf.model.ServiceZoo;
import com.zaza.ecf.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class GestionServiceController {

    @Autowired
    public ServiceService serviceService;

    @GetMapping("/gestion-services")
    public String gestionUtilisateur(Model model) {
        model.addAttribute("listeService",serviceService.recupererListeService());
        ServiceZoo nouveauxService = new ServiceZoo();
        model.addAttribute("nouveauxService", nouveauxService);
        return "gestion-services";
    }

    @PostMapping("/creerServiceModel")
    public String creerService(@ModelAttribute("nouveauxService") ServiceZoo servicezoo) {
        serviceService.creerService(servicezoo);
        return "redirect:gestion-services";
    }

    @PostMapping("/modifierServiceModel/{id}")
    public String  modifierService(@PathVariable Long id,@ModelAttribute ServiceZoo serviceZoo) {
        serviceService.modifierService((serviceZoo));
        return "redirect:../gestion-services";
    }

    @GetMapping("/supprimerServiceModel/{id}")
    public String supprimerService(@PathVariable Long id) {
        serviceService.supprimerService(id);
        return "redirect:../gestion-services";
    }

}
