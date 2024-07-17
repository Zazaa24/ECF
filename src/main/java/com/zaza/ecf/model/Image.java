package com.zaza.ecf.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="image")
public class Image {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "image_data")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "habitat_id",nullable = true)
    private Habitat habitat;

    @ManyToOne
    @JoinColumn(name = "animal_id",nullable = true)
    private Animal animal;

    public Habitat getHabitat() {
        return habitat;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
