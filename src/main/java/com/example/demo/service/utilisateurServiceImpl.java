package com.example.demo.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.utilisateur;
import com.example.demo.repository.utilisateurRepository;

@Service
public class utilisateurServiceImpl implements utilisateurService {

    // @Autowired
    // private utilisateurRepository userRepository;

    // Injection par constructeur
    private final utilisateurRepository userRepository;

    public utilisateurServiceImpl(utilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public utilisateur saveUtilisateur(utilisateur u) {
        return userRepository.save(u);
    }

    @Override
    public utilisateur updateUtilisateur(utilisateur u) {
        return userRepository.save(u);
    }

    @Override
    public void deleteutilisateur(utilisateur u) {
        userRepository.delete(u);
    }

    @Override
    public void deleteutilisateurById(Long id) {
        userRepository.deleteById(id.intValue());
    }

    @Override
    public utilisateur getutilisateur(Long id) {
        return userRepository.findById(id.intValue()).orElse(null);
    }

    @Override
    public List<utilisateur> getAllUtilisateurs() {
        return userRepository.findAll();
    }
}
