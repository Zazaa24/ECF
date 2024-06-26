package com.zaza.ecf.controller;



import com.zaza.ecf.model.Animal;
import com.zaza.ecf.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    public AnimalService animalService;

    @GetMapping("/recupererListeAnimal")
    public List<Animal> recupererListeAnimal() {
        return animalService.recupererListeAnimal();
    }

    @PostMapping(path = "/animal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal creerAnimal(@RequestBody Animal animal ) {
        return animalService.creerAnimal(animal);
    }

    @PutMapping(path = "/animal/{id}")
    public Animal modifierAnimal(@RequestBody Animal animal,@PathVariable Long id) {
        animal.setId(id);
        return animalService.modifierAnimal(animal);
    }

    @DeleteMapping(path = "/animal/{id}")
    public void supprimerAnimal(@PathVariable Long id) {
        animalService.supprimerAnimal(id);
    }
}
