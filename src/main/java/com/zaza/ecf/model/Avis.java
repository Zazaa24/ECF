package com.zaza.ecf.model;

import jakarta.persistence.*;

/**
 * Représentation de la base de donnée
 */
@Entity
@Table(name = "avis")
public class Avis {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name ="commentaire")
    private String commentaire;

    @Column(name ="est_visible")
    private Boolean estVisible = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Boolean getEstVisible() {
        return estVisible;
    }

    public void setEstVisible(Boolean estVisible) {
        this.estVisible = estVisible;
    }
}
