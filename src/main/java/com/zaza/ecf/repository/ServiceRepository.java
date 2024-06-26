package com.zaza.ecf.repository;

import com.zaza.ecf.model.ServiceZoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceZoo,Long> {
}
