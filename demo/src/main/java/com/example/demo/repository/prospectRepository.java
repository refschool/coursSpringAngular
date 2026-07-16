package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.*;

public interface prospectRepository extends JpaRepository<prospect, Integer> {
    @Query("SELECT p FROM prospect p WHERE p.commercial = :commercial")
    List<prospect> findByCommercial(@Param("commercial") commercial commercial);

    @Query("SELECT p FROM prospect p WHERE p.nomProspect LIKE %:nom%")
    List<prospect> findByNomProspectContains(@Param("nom") String nom);
}
