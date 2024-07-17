package com.zaza.ecf.controller;

import com.zaza.ecf.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.zaza.ecf.service.ImageService;

import java.util.Optional;

@Controller
public class ImageController {

    @Autowired
    public ImageService imageService;

    @GetMapping("image/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable("id") Long id) {
        Optional<Image> optionalImage = imageService.recupererImageParId(id);
        if(optionalImage.isPresent()){
            Image image = optionalImage.get();
            Resource file = new ByteArrayResource(image.getImage());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getId() + ".jpg" + "\"").body(file);
        }
        return null;
    }
}
