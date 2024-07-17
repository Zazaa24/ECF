package com.zaza.ecf.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "rapport_veterinaire")
public class RapportVeterinaire {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "time")
    @DateTimeFormat(pattern = "HH-mm")
    private LocalTime time;

    @Column(name = "detail")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = false)
    private Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name = "alimentation_id", nullable = true)
    private Alimentation alimentation;

    @ManyToOne
    @JoinColumn(name = "animal_id",nullable = false)
    private Animal animal;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Alimentation getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
