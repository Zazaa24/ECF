package com.zaza.ecf.controller;

import com.zaza.ecf.model.Avis;
import com.zaza.ecf.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Permet de faire le lien avec l'exterieur via des requête HTTP
 *
 */
@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    public AvisService avisService;

    @GetMapping("/recupererListeAvis")
    public List<Avis> recupererListeAvis(@RequestParam(name = "estVisible", required = false) Boolean estVisible) {
        if(Objects.isNull(estVisible)){
            return avisService.recupererListeAvis();
        } else {
            return avisService.recupererListeAvisParVisible(estVisible);
        }
    }

    @PostMapping(path = "/avis",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Avis creerAvis(@RequestBody Avis avis ) {
            return avisService.creerAvis(avis);
    }

    @PatchMapping(path = "/avis/{id}")
    public Avis modifierAvis(@RequestParam(name = "estVisible", required = true) Boolean estVisible, @PathVariable Long id) {

        Optional<Avis> optionalAvis = avisService.recupererAvisParId(id);
        if(optionalAvis.isPresent()){
            Avis avis = optionalAvis.get();
            avis.setEstVisible(estVisible);
            return avisService.modifierAvis(avis);
        }
        return null;
    }

    @DeleteMapping(path = "/avis/{id}")
    public void supprimerAvis(@PathVariable Long id) {
        avisService.supprimerAvis(id);
    }
}
