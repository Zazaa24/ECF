package com.zaza.ecf.service;


import com.zaza.ecf.model.ServiceZoo;
import com.zaza.ecf.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ServiceService {

    @Autowired
    private ServiceRepository repo;

    public List<ServiceZoo> recupererListeService() {
        return repo.findAll();
    }

    public ServiceZoo creerService (ServiceZoo serviceZoo) {
        repo.save(serviceZoo);
        return serviceZoo;
    }

    public Optional<ServiceZoo> recupererServiceParId(Long id){
        return repo.findById(id);
    }

    public ServiceZoo modifierService (ServiceZoo serviceZoo) {
        repo.save(serviceZoo);
        return serviceZoo;
    }

    public void supprimerService (Long id) {
        repo.deleteById(id);
    }
}
