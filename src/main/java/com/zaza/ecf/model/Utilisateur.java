package com.zaza.ecf.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @JsonManagedReference
    private Role role;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Alimentation> alimentations;

    @OneToMany(mappedBy = "utilisateur")
    private Set<RapportVeterinaire> rapportVeterinaires;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}

//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "role_id", referencedColumnName = "id")
// @OnDelete(action = OnDeleteAction.CASCADE)