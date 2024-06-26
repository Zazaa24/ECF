package com.zaza.ecf.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rapport_id",nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RapportVeterinaire rapportVeterinaire;

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

    public RapportVeterinaire getRapportVeterinaire() {
        return rapportVeterinaire;
    }

    public void setRapportVeterinaire(RapportVeterinaire rapportVeterinaire) {
        this.rapportVeterinaire = rapportVeterinaire;
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
