package com.zaza.ecf.controller;



import com.zaza.ecf.model.ServiceZoo;
import com.zaza.ecf.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service")

public class ServiceController {

    @Autowired
    public ServiceService serviceService;

    @GetMapping("/recupererListeService")
    public List<ServiceZoo> recupererListeService() {
        return serviceService.recupererListeService();
    }

    @PostMapping(path = "/service",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceZoo creerService(@RequestBody ServiceZoo serviceZoo ) {
        return serviceService.creerService(serviceZoo);
    }

    @PutMapping(path = "/service/{id}")
    public ServiceZoo modifierService(@RequestBody ServiceZoo serviceZoo,@PathVariable Long id) {
          serviceZoo.setId(id);
          return serviceService.modifierService(serviceZoo);
    }

    @DeleteMapping(path = "/service/{id}")
    public void supprimerService(@PathVariable Long id) {
        serviceService.supprimerService(id);
    }

}
