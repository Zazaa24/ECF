package com.zaza.ecf.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.sql.Timestamp;

@Entity
@Table(name = "alimentation")
public class Alimentation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nourriture_propose")
    private String nourriturePropose;

    @Column(name = "quantite")
    private String quantite;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "animal_id",nullable = false)
    private Animal animal;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNourriturePropose() {
        return nourriturePropose;
    }

    public void setNourriturePropose(String nourriturePropose) {
        this.nourriturePropose = nourriturePropose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
