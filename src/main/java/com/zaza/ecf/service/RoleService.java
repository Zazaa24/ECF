package com.zaza.ecf.service;


import com.zaza.ecf.model.Role;
import com.zaza.ecf.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository repo;

    public List<Role> recupererListeRole() {
        return repo.findAll();
    }

    public Role creerRole (Role role) {
        repo.save(role);
        return role;
    }

    public Optional<Role> recupererRoleParId(Long id){
        return repo.findById(id);
    }

    public Role modifierRole (Role role) {
        repo.save(role);
        return role;
    }

    public void supprimerRole (Long id) {
        repo.deleteById(id);
    }
}
