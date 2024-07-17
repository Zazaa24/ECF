package com.zaza.ecf.controller;


import com.zaza.ecf.model.Role;
import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.service.MailService;
import com.zaza.ecf.service.UtilisateurService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GestionUtilisateurController {

    @Autowired
    public UtilisateurService utilisateurService;
    @Autowired
    public MailService mailService;

    @GetMapping("/gestion-utilisateurs")
    public String gestionUtilisateur(Model model) {
        model.addAttribute("listeUtilisateur",utilisateurService.recupererListeUtilisateur());
        Utilisateur nouvelUtilisateur = new Utilisateur();
        nouvelUtilisateur.setRole(new Role());
        model.addAttribute("nouvelUtilisateur", nouvelUtilisateur);
        return "gestion-utilisateurs";
    }

    @PostMapping("/creerUtilisateurModel")
    public String creerUtilisateur(@ModelAttribute("nouvelUtilisateur")Utilisateur utilisateur) throws MessagingException {
        utilisateurService.creerUtilisateur(utilisateur);
        mailService.sendEmailInvitation(utilisateur.getUsername());
        return "redirect:gestion-utilisateurs";
    }

    @PostMapping("/modifierUtilisateurModel/{id}")
    public String  modifierUtilisateur(@PathVariable Long id, @ModelAttribute Utilisateur utilisateur) {
        utilisateurService.modifierUtilisateur((utilisateur));
        return "redirect:../gestion-utilisateurs";
    }

    @GetMapping("/supprimerUtilisateurModel/{id}")
    public String supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
        return "redirect:../gestion-utilisateurs";
    }
}
