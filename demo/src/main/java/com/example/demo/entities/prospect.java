package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class prospect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProspect;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String entreprise;
    private String source;

    @ManyToOne
    @JoinColumn(name = "id_commercial")
    private commercial commercial;

    @ManyToOne
    @JoinColumn(name = "id_etat_avancement")
    private etatAvancement etatAvancement;

    private LocalDateTime dateCreation;

    public prospect() {
        super();
    }

    public Integer getIdProspect() {
        return idProspect;
    }

    public void setIdProspect(Integer idProspect) {
        this.idProspect = idProspect;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public commercial getCommercial() {
        return commercial;
    }

    public void setCommercial(commercial commercial) {
        this.commercial = commercial;
    }

    public etatAvancement getEtatAvancement() {
        return etatAvancement;
    }

    public void setEtatAvancement(etatAvancement etatAvancement) {
        this.etatAvancement = etatAvancement;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    // Getters / Setters
}
