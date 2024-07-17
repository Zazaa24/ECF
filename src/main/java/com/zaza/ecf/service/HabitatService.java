package com.zaza.ecf.service;


import com.zaza.ecf.model.Habitat;
import com.zaza.ecf.repository.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HabitatService {

    @Autowired
    private HabitatRepository repo;

    public List<Habitat> recupererListeHabitat() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Habitat creerHabitat (Habitat habitat) {
        repo.save(habitat);
        return habitat;
    }

    public Optional<Habitat> recupererHabitatParId(Long id){
        return repo.findById(id);
    }

    public Habitat modifierHabitat (Habitat habitat) {
        repo.save(habitat);
        return habitat;
    }

    public void supprimerHabitat (Long id) {
        repo.deleteById(id);
    }
}
