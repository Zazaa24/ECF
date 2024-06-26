package com.zaza.ecf.controller;



import com.zaza.ecf.model.Race;
import com.zaza.ecf.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    public RaceService raceService;

    @GetMapping("/recupererListeRace")
    public List<Race> recupererListeRace() {
        return raceService.recupererListeRace();
    }

    @PostMapping(path = "/race",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Race creerRace(@RequestBody Race race ) {
        return raceService.creerRace(race);
    }

    @PutMapping(path = "/race/{id}")
    public Race modifierRace(@RequestBody Race race,@PathVariable Long id) {
        race.setId(id);
        return raceService.modifierRace(race);
    }

    @DeleteMapping(path = "/race/{id}")
    public void supprimerRace(@PathVariable Long id) {
        raceService.supprimerRace(id);
    }
}
