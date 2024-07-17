package com.zaza.ecf.controller;


import com.zaza.ecf.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @Autowired
    public ServiceService serviceService;

    @GetMapping("/services")
    public String service(Model model) {
        model.addAttribute("listeService",serviceService.recupererListeService());
        return "services";
    }
}
