package com.zaza.ecf.service;

import com.zaza.ecf.model.Avis;
import com.zaza.ecf.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AvisService {

    @Autowired
    private AvisRepository repo;

    public List<Avis> recupererListeAvis(){
        return repo.findAll();
    }

    public List<Avis> recupererListeAvisParVisible(Boolean estVisible){
        return repo.findAllByVisible(estVisible);
    }

    public Avis creerAvis (Avis avis) {
        repo.save(avis);
        return avis;
    }

    public Optional<Avis> recupererAvisParId(Long id){
        return repo.findById(id);
    }

    public Avis modifierAvis (Avis avis) {
        repo.save(avis);
        return avis;
    }

    public void supprimerAvis (Long id) {
        repo.deleteById(id);
    }
}
