package com.zaza.ecf.controller;


import com.zaza.ecf.model.Animal;
import com.zaza.ecf.model.Image;
import com.zaza.ecf.service.AnimalService;
import com.zaza.ecf.service.HabitatService;
import com.zaza.ecf.service.ImageService;
import com.zaza.ecf.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class GestionAnimalController {

    @Autowired
    public AnimalService animalService;
    @Autowired
    public ImageService imageService;
    @Autowired
    public RaceService raceService;
    @Autowired
    public HabitatService habitatService;

    @GetMapping("gestion-animaux")
    public String gestionAnimal(Model model) {
        model.addAttribute("listeAnimal",animalService.recupererListeAnimal());
        Animal nouvelAnimal = new Animal();
        model.addAttribute("nouvelAnimal", nouvelAnimal);
        model.addAttribute("listeRace",raceService.recupererListeRace());
        model.addAttribute("listeHabitat",habitatService.recupererListeHabitat());
        return "gestion-animaux";
    }

    @PostMapping("/creerAnimalModel")
    public String creerAnimal(@ModelAttribute("nouvelAnimal") Animal animal) {
        animalService.creerAnimal(animal);
        return "redirect:gestion-animaux";
    }

    @PostMapping("/modifierAnimalModel/{id}")
    public String  modifierAnimal(@PathVariable Long id, @ModelAttribute Animal animal) {
        animalService.modifierAnimal((animal));
        return "redirect:../gestion-animaux";
    }

    @GetMapping("/supprimerAnimalModel/{id}")
    public String supprimerAnimal(@PathVariable Long id) {
        animalService.supprimerAnimal(id);
        return "redirect:../gestion-animaux";
    }

    @PostMapping("creerImageAnimal/{id}")
    public String creerImageAnimal(@PathVariable Long id,Model model, @RequestParam("file") MultipartFile fichier) throws IOException {
        Image image = new Image();
        image.setImage(fichier.getBytes());
        Animal animal = new Animal();
        animal.setId(id);
        image.setAnimal(animal);
        imageService.creerImage(image);
        return "redirect:../gestion-animaux";
    }

    @GetMapping("/supprimerImageAnimalModel/{id}")
    public String supprimerImageAnimal(@PathVariable Long id) {
        imageService.supprimerImage(id);
        return "redirect:../gestion-animaux";
    }
}

