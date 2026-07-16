package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.commercial;
import com.example.demo.entities.prospect;
import com.example.demo.repository.commercialRepository;
import com.example.demo.repository.prospectRepository;

@Service
public class prospectServiceImpl implements prospectService {

    private final prospectRepository prospectRepository;
    private final commercialRepository commercialRepository;

    public prospectServiceImpl(prospectRepository prospectRepository,
            commercialRepository commercialRepository) {
        this.prospectRepository = prospectRepository;
        this.commercialRepository = commercialRepository;
    }

    @Override
    public prospect saveprospect(prospect p) {
        p.setIdProspect(null);
        return prospectRepository.save(p);
    }

    @Override
    public prospect updateprospect(prospect p) {

        if (p.getCommercial() != null && p.getCommercial().getIdCommercial() != null) {
            p.setCommercial(
                    commercialRepository.findById(p.getCommercial().getIdCommercial()).orElse(null));
        }

        return prospectRepository.save(p);
    }

    @Override
    public void deleteprospect(Integer id) {
        prospectRepository.deleteById(id);
    }

    @Override
    public prospect getprospect(Integer id) {
        return prospectRepository.findById(id).orElse(null);
    }

    @Override
    public List<prospect> getAllprospects() {
        return prospectRepository.findAll();
    }

    @Override
    public List<prospect> findByCommercial(commercial commercial) {
        return prospectRepository.findByCommercial(commercial);
    }
}