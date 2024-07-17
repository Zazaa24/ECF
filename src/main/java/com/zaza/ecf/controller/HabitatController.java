package com.zaza.ecf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HabitatController {

    @GetMapping("/habitats")
    public String habitat(Model model) {
        return "habitats";
    }
}
