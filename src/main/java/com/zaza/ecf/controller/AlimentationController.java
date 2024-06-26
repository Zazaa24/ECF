package com.zaza.ecf.controller;



import com.zaza.ecf.model.Alimentation;
import com.zaza.ecf.service.AlimentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentation")
public class AlimentationController {

    @Autowired
    public AlimentationService alimentationService;

    @GetMapping("/recupererListeAlimentation")
    public List<Alimentation> recupererListeAlimentation() {
        return alimentationService.recupererListeAlimentation();
    }

    @PostMapping(path = "/alimentation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Alimentation creerAlimentation(@RequestBody Alimentation alimentation ) {
        return alimentationService.creerAlimentation(alimentation);
    }

    @PutMapping(path = "/alimentation/{id}")
    public Alimentation modifierAlimentation(@RequestBody Alimentation alimentation,@PathVariable Long id) {
        alimentation.setId(id);
        return alimentationService.modifierAlimentation(alimentation);
    }

    @DeleteMapping(path = "/alimentation/{id}")
    public void supprimerAlimentation(@PathVariable Long id) {
        alimentationService.supprimerAlimentation(id);
    }
}
