package com.zaza.ecf.service;



import com.zaza.ecf.model.Race;
import com.zaza.ecf.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RaceService {

    @Autowired
    private RaceRepository repo;

    public List<Race> recupererListeRace() {
        return repo.findAll();
    }

    public Race creerRace (Race race) {
        repo.save(race);
        return race;
    }

    public Optional<Race> recupererRaceParId(Long id){
        return repo.findById(id);
    }

    public Race modifierRace (Race race) {
        repo.save(race);
        return race;
    }

    public void supprimerRace (Long id) {
        repo.deleteById(id);
    }
}
