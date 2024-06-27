package com.zaza.ecf.restController;



import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/utilisateur")

public class UtilisateurController {

    @Autowired
    public UtilisateurService utilisateurservice;

    @GetMapping("/recupererListeUtilisateur")
    public List<Utilisateur> recupererListeUtilisateur() {
        return utilisateurservice.recupererListeUtilisateur();
    }

    @PostMapping(path = "/utilisateur",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilisateur creerUtilisateur(@RequestBody Utilisateur utilisateur ) {
        return utilisateurservice.creerUtilisateur(utilisateur);
    }

    @PutMapping(path = "/utilisateur/{id}")
    public Utilisateur modifierService(@RequestBody Utilisateur utilisateur,@PathVariable Long id) {
        utilisateur.setId(id);
        return utilisateurservice.modifierUtilisateur(utilisateur);
    }

    @DeleteMapping(path = "/utilisateur/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        utilisateurservice.supprimerUtilisateur(id);
    }
}
