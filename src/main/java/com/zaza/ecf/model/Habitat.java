package com.zaza.ecf.model;


import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "habitat")
public class Habitat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "commentaire_habitat")
    private String commentaireHabitat;


    @OneToMany(mappedBy = "habitat")
    private Set<Animal> animals;

    @OneToMany(mappedBy = "habitat")
    private Set<Image> images;

    public String getCommentaireHabitat() {
        return commentaireHabitat;
    }

    public void setCommentaireHabitat(String commentaireHabitat) {
        this.commentaireHabitat = commentaireHabitat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Image[] getImagesArray(){
        if (this.images != null ){
        Image[] imageArray = this.images.toArray(new Image[this.images.size()]);
        return imageArray;
        }
        return new Image[0];
    }
}
