package com.zaza.ecf.service;


import com.zaza.ecf.model.Image;
import com.zaza.ecf.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageService {

    @Autowired
    private ImageRepository repo;

    public List<Image> recupererListeImage() {
        return repo.findAll();
    }

    public Image creerImage (Image image) {
        repo.save(image);
        return image;
    }

    public Optional<Image> recupererImageParId(Long id){
        return repo.findById(id);
    }

    public void supprimerImage (Long id) {
        repo.deleteById(id);
    }
}
