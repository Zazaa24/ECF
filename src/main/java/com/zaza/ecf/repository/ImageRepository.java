package com.zaza.ecf.repository;

import com.zaza.ecf.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository <Image,Long> {
}
