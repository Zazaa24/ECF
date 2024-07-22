package com.zaza.ecf.controller;


import com.zaza.ecf.service.AnimalService;
import com.zaza.ecf.service.HabitatService;
import com.zaza.ecf.service.ImageService;
import com.zaza.ecf.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HabitatController {

    @Autowired
    public AnimalService animalService;
    @Autowired
    public HabitatService habitatService;
    @Autowired
    public ImageService imageService;

    @GetMapping("/habitats")
    public String habitat(Model model) {
        model.addAttribute("listeHabitat",habitatService.recupererListeHabitat());
        model.addAttribute("listeAnimal",animalService.recupererListeAnimal());
        model.addAttribute("listeImage",imageService.recupererListeImage());
        return "habitats";
    }
}
