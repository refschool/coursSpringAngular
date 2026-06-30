package com.example.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomUser", types = { utilisateur.class })
public interface ProduitProjection {
    public String getNom();
}