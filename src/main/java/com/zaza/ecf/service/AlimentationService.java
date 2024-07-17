package com.zaza.ecf.service;


import com.zaza.ecf.model.Alimentation;
import com.zaza.ecf.repository.AlimentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlimentationService {

    @Autowired
    private AlimentationRepository repo;

    public List<Alimentation> recupererListeAlimentation() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Alimentation creerAlimentation (Alimentation alimentation) {
        repo.save(alimentation);
        return alimentation;
    }

    public Optional<Alimentation> recupererAlimentationParId(Long id){
        return repo.findById(id);
    }

    public Alimentation modifierAlimentation (Alimentation alimentation) {
        repo.save(alimentation);
        return alimentation;
    }

    public void supprimerAlimentation (Long id) {
        repo.deleteById(id);
    }
}
