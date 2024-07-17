package com.zaza.ecf.service;


import com.zaza.ecf.model.RapportVeterinaire;
import com.zaza.ecf.repository.RapportVeterinaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RapportVeterinaireService {

    @Autowired
    private RapportVeterinaireRepository repo;

    public List<RapportVeterinaire> recupererListeRapportVeterinaire() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public RapportVeterinaire creerRapportVeterinaire (RapportVeterinaire rapportVeterinaire) {
        repo.save(rapportVeterinaire);
        return rapportVeterinaire;
    }

    public Optional<RapportVeterinaire> recupererRapportVeterinaireParId(Long id){
        return repo.findById(id);
    }

    public RapportVeterinaire modifierRapportVeterinaire (RapportVeterinaire rapportVeterinaire) {
        repo.save(rapportVeterinaire);
        return rapportVeterinaire;
    }

    public void supprimerRapportVeterinaire (Long id) {
        repo.deleteById(id);
    }
}
