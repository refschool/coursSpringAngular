package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.utilisateur;

@RepositoryRestResource(path = "rest")
public interface utilisateurRepository extends JpaRepository<utilisateur, Integer> {
    List<utilisateur> findByNom(String nom);

    List<utilisateur> findByNomContains(String nom);

    @Query("SELECT u FROM utilisateur u WHERE u.nom LIKE %:nom% AND u.prenom LIKE %:prenom%")
    List<utilisateur> searchByNomPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

    @Query("SELECT u FROM utilisateur u ORDER BY u.nom ASC")
    List<utilisateur> findAllOrderByNomAsc();

    @Query("SELECT u FROM utilisateur u ORDER BY u.nom ASC, u.prenom DESC")
    List<utilisateur> findAllOrderByNomAscPrenomDESC();

}
