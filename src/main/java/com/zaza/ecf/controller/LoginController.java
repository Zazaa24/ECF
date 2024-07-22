package com.zaza.ecf.controller;


import com.zaza.ecf.model.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @GetMapping("/non-autorise")
    public String nonAutorise(Model model) {
        return "non-autorise";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("authentication", new Utilisateur());
        return "login";
    }
}
