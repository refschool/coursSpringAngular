package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class etatAvancement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtatAvancement;

    private String libelle;
    private Integer ordreEtape;

    @OneToMany(mappedBy = "etatAvancement")
    private List<prospect> prospects;

    public etatAvancement() {
        super();
    }

    public Integer getIdEtatAvancement() {
        return idEtatAvancement;
    }

    public void setIdEtatAvancement(Integer idEtatAvancement) {
        this.idEtatAvancement = idEtatAvancement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getOrdreEtape() {
        return ordreEtape;
    }

    public void setOrdreEtape(Integer ordreEtape) {
        this.ordreEtape = ordreEtape;
    }

    public List<prospect> getProspects() {
        return prospects;
    }

    public void setProspects(List<prospect> prospects) {
        this.prospects = prospects;
    }

    // Getters / Setters
}
