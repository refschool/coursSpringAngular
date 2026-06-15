package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.utilisateur;

public interface utilisateurRepository extends JpaRepository<utilisateur, Integer> {

}
