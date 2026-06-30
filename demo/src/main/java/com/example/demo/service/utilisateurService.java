package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.*;

public interface utilisateurService {
    utilisateur saveUtilisateur(utilisateur u);

    utilisateur updateUtilisateur(utilisateur u);

    void deleteutilisateur(utilisateur u);

    void deleteutilisateurById(Long id);

    utilisateur getutilisateur(Long id);

    List<utilisateur> getAllUtilisateurs();

    List<utilisateur> findByNom(String nom);

    List<utilisateur> findByNomContains(String nom);

    List<utilisateur> searchByNomPrenom(String nom, String prenom);

    List<utilisateur> findAllOrderByNomAsc();

    List<utilisateur> findAllOrderByNomAscPrenomDESC();

}
