package com.zaza.ecf.restController;

import com.zaza.ecf.model.Habitat;
import com.zaza.ecf.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitat")
public class HabitatRestController {

    @Autowired
    public HabitatService habitatService;

    @GetMapping("/recupererListeHabitat")
    public List<Habitat> recupererListeHabitat() {
        return habitatService.recupererListeHabitat();
    }

    @PostMapping(path = "/habitat",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Habitat creerHabitat(@RequestBody Habitat habitat ) {
        return habitatService.creerHabitat(habitat);
    }

    @PutMapping(path = "/habitat/{id}")
    public Habitat modifierHabitat(@RequestBody Habitat habitat,@PathVariable Long id) {
        habitat.setId(id);
        return habitatService.modifierHabitat(habitat);
    }

    @DeleteMapping(path = "/habitat/{id}")
    public void supprimerHabitat(@PathVariable Long id) {
        habitatService.supprimerHabitat(id);
    }
}
