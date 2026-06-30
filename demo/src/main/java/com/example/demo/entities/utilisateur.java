package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_utilisateur;

    private String nom;

    private String prenom;

    @Column(unique = true)
    private String email;

    private String mot_de_passe;

    private String role;

    private LocalDateTime date_creation;

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
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

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public utilisateur() {
        super();
    }

    public utilisateur(String nom, String prenom, String email, String mot_de_passe, String role,
            LocalDateTime date_creation) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "utilisateur [id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email="
                + email + ", mot_de_passe=" + mot_de_passe + ", role=" + role + ", date_creation=" + date_creation
                + "]";
    }

}
