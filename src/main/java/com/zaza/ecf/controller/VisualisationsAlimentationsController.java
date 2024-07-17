package com.zaza.ecf.controller;


import com.zaza.ecf.service.AlimentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisualisationsAlimentationsController {

    @Autowired
    public AlimentationService alimentationService;


    @GetMapping("/visualisation-alimentations")
    public String visualisationAlimentation(Model model) {
        model.addAttribute("listeAlimentation",alimentationService.recupererListeAlimentation());
        return "visualisation-alimentations";
    }
}
