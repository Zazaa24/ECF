package com.zaza.ecf.repository;

import com.zaza.ecf.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvisRepository extends JpaRepository<Avis,Long> {

    @Query(value = "SELECT * FROM avis WHERE est_visible = ?1", nativeQuery = true)
    List<Avis> findAllByVisible(Boolean estVisible);

}
