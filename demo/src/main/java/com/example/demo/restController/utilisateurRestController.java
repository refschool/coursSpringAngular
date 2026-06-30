package com.example.demo.restController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.utilisateur;
import com.example.demo.service.utilisateurService;

@RestController
@RequestMapping("/api")
public class utilisateurRestController {

    private final utilisateurService utilisateurService;

    public utilisateurRestController(utilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public utilisateur getUtilisateurById(@PathVariable("id") Long id) {
        return utilisateurService.getutilisateur(id);
    }

    @PostMapping
    public utilisateur createUtilisateur(@RequestBody utilisateur u) {
        return utilisateurService.saveUtilisateur(u);
    }

    @PutMapping
    public utilisateur updateUtilisateur(@RequestBody utilisateur u) {
        return utilisateurService.updateUtilisateur(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable("id") Long id) {
        utilisateurService.deleteutilisateurById(id);
    }

}
