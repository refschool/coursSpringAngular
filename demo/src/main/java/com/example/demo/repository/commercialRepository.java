package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.commercial;

@RepositoryRestResource(path = "commercial")
@CrossOrigin("http://localhost:4200/") // pour autoriser angular
public interface commercialRepository extends JpaRepository<commercial, Integer> {

}