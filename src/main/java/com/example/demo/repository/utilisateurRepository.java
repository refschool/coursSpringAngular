package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.utilisateur;

public interface utilisateurRepository extends JpaRepository<utilisateur, Integer> {
    List<utilisateur> findByNom(String nom);

    List<utilisateur> findByNomContains(String nom);
}
