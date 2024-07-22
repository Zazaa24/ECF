package com.zaza.ecf.service;



import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository repo;

    public List<Utilisateur> recupererListeUtilisateur() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Utilisateur creerUtilisateur (Utilisateur utilisateur) {
        repo.save(utilisateur);
        return utilisateur;
    }

    public Optional<Utilisateur> recupererUtilisateurParId(Long id){
        return repo.findById(id);
    }

    public Optional<Utilisateur> recupererUtilisateurParUsername(String username){
        return repo.findByUsername(username);
    }

    public Utilisateur modifierUtilisateur (Utilisateur utilisateur) {
        repo.save(utilisateur);
        return utilisateur;
    }

    public void supprimerUtilisateur (Long id) {
        repo.deleteById(id);
    }
}
