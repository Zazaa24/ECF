package com.zaza.ecf.service;


import com.zaza.ecf.model.Horaire;
import com.zaza.ecf.repository.HoraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HoraireService {

    @Autowired
    private HoraireRepository repo;

    public List<Horaire> recupererListeHoraire() {
        return repo.findAll();
    }

    public Horaire creerHoraire (Horaire horaire) {
        repo.save(horaire);
        return horaire;
    }

    public Optional<Horaire> recupererHoraireParId(Long id){
        return repo.findById(id);
    }

    public Horaire modifierHoraire (Horaire horaire) {
        repo.save(horaire);
        return horaire;
    }

    public void supprimerHoraire (Long id) {
        repo.deleteById(id);
    }

}
