package com.zaza.ecf.controller;


import com.zaza.ecf.model.Habitat;
import com.zaza.ecf.model.Image;
import com.zaza.ecf.service.HabitatService;
import com.zaza.ecf.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;


@Controller
public class GestionHabitatController {

    @Autowired
    public ImageService imageService;

    @Autowired
    public HabitatService habitatService;

    @GetMapping("gestion-habitats")
    @PreAuthorize("hasAnyRole('ADMINISTRATEUR', 'VETERINAIRE')")
    public String gestionHabitats(Model model) {
        model.addAttribute("listeHabitat",habitatService.recupererListeHabitat());
        Habitat nouvelHabitat = new Habitat();
        model.addAttribute("nouvelHabitat", nouvelHabitat);
        return "gestion-habitats";
    }

    @PostMapping("/creerHabitatModel")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String creerHabitat(@ModelAttribute("nouvelHabitat") Habitat habitat) {
        habitatService.creerHabitat(habitat);
        return "redirect:gestion-habitats";
    }

    @PostMapping("/modifierHabitatModel/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String  modifierHabitat(@PathVariable Long id,@ModelAttribute Habitat habitat) {
        habitatService.modifierHabitat((habitat));
        return "redirect:../gestion-habitats";
    }

    @PostMapping("/modifierCommentaireModel/{id}")
    @PreAuthorize("hasAuthority('ROLE_VETERINAIRE')")
    public String  modifierCommentaireHabitat(@PathVariable Long id,@ModelAttribute Habitat habitatModel) {
        Optional<Habitat> optionalHabitat = habitatService.recupererHabitatParId(id);
        if(optionalHabitat.isPresent()) {
            Habitat habitat = optionalHabitat.get();
            habitat.setCommentaireHabitat(habitatModel.getCommentaireHabitat());
            habitatService.modifierHabitat((habitat));
        }
        return "redirect:../gestion-habitats";
    }


    @GetMapping("/supprimerHabitatModel/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String supprimerHabitat(@PathVariable Long id) {
        habitatService.supprimerHabitat(id);
        return "redirect:../gestion-habitats";
    }

    @PostMapping("creerImageHabitat/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String creerImageHabitat(@PathVariable Long id,Model model, @RequestParam("file")MultipartFile fichier) throws IOException {
        Image image = new Image();
        image.setImage(fichier.getBytes());
        Habitat habitat = new Habitat();
        habitat.setId(id);
        image.setHabitat(habitat);
        imageService.creerImage(image);
        return "redirect:../gestion-habitats";
    }

    @GetMapping("/supprimerImageHabitatModel/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    public String supprimerImageHabitat(@PathVariable Long id) {
        imageService.supprimerImage(id);
        return "redirect:../gestion-habitats";
    }
}
