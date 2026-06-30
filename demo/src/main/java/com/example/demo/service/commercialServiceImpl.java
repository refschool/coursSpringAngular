package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.commercial;
import com.example.demo.repository.commercialRepository;

@Service
public class commercialServiceImpl implements commercialService {

    private final commercialRepository commercialRepository;

    public commercialServiceImpl(commercialRepository commercialRepository) {
        this.commercialRepository = commercialRepository;
    }

    @Override
    public commercial savecommercial(commercial c) {
        return commercialRepository.save(c);
    }

    @Override
    public commercial updatecommercial(commercial c) {
        return commercialRepository.save(c);
    }

    @Override
    public void deletecommercial(Integer id) {
        commercialRepository.deleteById(id);
    }

    @Override
    public commercial getcommercial(Integer id) {
        return commercialRepository.findById(id).orElse(null);
    }

    @Override
    public List<commercial> getAllcommercials() {
        return commercialRepository.findAll();
    }
}
