package com.zaza.ecf.controller;


import com.zaza.ecf.model.Role;
import com.zaza.ecf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/role")

public class RoleController {

    @Autowired
    public RoleService roleservice;

    @GetMapping("/recupererListeRole")
    public List<Role> recupererListeRole() {
        return roleservice.recupererListeRole();
    }

    @PostMapping(path = "/role",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Role creerRole(@RequestBody Role role ) {
        return roleservice.creerRole(role);
    }

    @PutMapping(path = "/role/{id}")
    public Role modifierRole(@RequestBody Role role,@PathVariable Long id) {
        role.setId(id);
        return roleservice.modifierRole(role);
    }

    @DeleteMapping(path = "/role/{id}")
    public void supprimerService(@PathVariable Long id) {
        roleservice.supprimerRole(id);
    }

}
