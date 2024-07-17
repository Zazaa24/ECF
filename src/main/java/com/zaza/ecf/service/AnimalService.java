package com.zaza.ecf.service;



import com.zaza.ecf.model.Animal;
import com.zaza.ecf.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository repo;

    public List<Animal> recupererListeAnimal() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Animal creerAnimal (Animal animal) {
        repo.save(animal);
        return animal;
    }

    public Optional<Animal> recupererAnimalParId(Long id){
        return repo.findById(id);
    }

    public Animal modifierAnimal (Animal animal) {
        repo.save(animal);
        return animal;
    }

    public void supprimerAnimal (Long id) {
        repo.deleteById(id);
    }
}
