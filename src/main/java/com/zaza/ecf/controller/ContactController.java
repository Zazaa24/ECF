package com.zaza.ecf.controller;


import com.zaza.ecf.model.Contact;
import com.zaza.ecf.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    public MailService mailService;

   @GetMapping("/contact")
    public String contact(@RequestParam(name="etat", required = false) String etat, Model model){
       model.addAttribute("etat", etat);
       Contact nouveauxContact = new Contact();
       model.addAttribute("nouveauxContact", nouveauxContact);
       return "contact";
   }

   @PostMapping("/demandeContact")
    public String demandeContact(@ModelAttribute("nouveauxContact") Contact demandeContact) throws MessagingException {
       mailService.sendEmailContact(demandeContact.getAdresseEmail(), demandeContact.getSujet(),demandeContact.getMessage());
       return "contact?etat=success";
   }
}

