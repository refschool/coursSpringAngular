package com.example.demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.entities.commercial;
import com.example.demo.entities.prospect;

public interface prospectService {

    prospect saveprospect(prospect p);

    prospect updateprospect(prospect p);

    void deleteprospect(Integer id);

    prospect getprospect(Integer id);

    List<prospect> getAllprospects();

    List<prospect> findByCommercial(commercial commercial);
}
