package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class commercial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommercial;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateEmbauche;

    @OneToMany(mappedBy = "commercial")
    @JsonIgnore
    private List<prospect> prospects;

    public commercial() {
        super();
    }

    public Integer getIdCommercial() {
        return idCommercial;
    }

    public void setIdCommercial(Integer idCommercial) {
        this.idCommercial = idCommercial;
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

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public List<prospect> getProspects() {
        return prospects;
    }

    public void setProspects(List<prospect> prospects) {
        this.prospects = prospects;
    }

    // Getters / Setters
}
