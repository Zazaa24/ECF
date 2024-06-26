package com.zaza.ecf.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "etat")
    private String etat;

    @OneToMany(mappedBy = "animal")
    @JsonBackReference
    private Set<Alimentation> alimentations;

    @OneToMany(mappedBy = "animal")
    @JsonBackReference
    private Set<RapportVeterinaire> rapportVeterinaires;

    @ManyToOne
    @JoinColumn(name = "race_id",nullable = false)
    @JsonManagedReference
    private Race race;

    @ManyToOne
    @JoinColumn(name = "habitat_id",nullable = false)
    @JsonManagedReference
    private Habitat habitat;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Alimentation> getAlimentations() {
        return alimentations;
    }

    public void setAlimentations(Set<Alimentation> alimentations) {
        this.alimentations = alimentations;
    }

    public Set<RapportVeterinaire> getRapportVeterinaires() {
        return rapportVeterinaires;
    }

    public void setRapportVeterinaires(Set<RapportVeterinaire> rapportVeterinaires) {
        this.rapportVeterinaires = rapportVeterinaires;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
