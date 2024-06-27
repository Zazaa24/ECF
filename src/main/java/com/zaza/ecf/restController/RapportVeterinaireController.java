package com.zaza.ecf.restController;


import com.zaza.ecf.model.RapportVeterinaire;
import com.zaza.ecf.service.RapportVeterinaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapportVeterinaire")

public class RapportVeterinaireController {

    @Autowired
    public RapportVeterinaireService rapportVeterinaireService;

    @GetMapping("/recupererListeRapportVeterinaire")
    public List<RapportVeterinaire> recupererListeRapportVeterinaire() {
        return rapportVeterinaireService.recupererListeRapportVeterinaire();
    }

    @PostMapping(path = "/rapportVeterinaire",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RapportVeterinaire creerRapportVeterinaire(@RequestBody RapportVeterinaire rapportVeterinaire ) {
        return rapportVeterinaireService.creerRapportVeterinaire(rapportVeterinaire);
    }

    @PutMapping(path = "/rapportVeterinaire/{id}")
    public RapportVeterinaire modifierRapportVeterinaire(@RequestBody RapportVeterinaire rapportVeterinaire,@PathVariable Long id) {
        rapportVeterinaire.setId(id);
        return rapportVeterinaireService.modifierRapportVeterinaire(rapportVeterinaire);
    }

    @DeleteMapping(path = "/rapportVeterinaire/{id}")
    public void supprimerRapportVeterinaire(@PathVariable Long id) {
        rapportVeterinaireService.supprimerRapportVeterinaire(id);
    }
}
