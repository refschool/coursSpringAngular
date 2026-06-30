package com.example.demo.service;

import com.example.demo.entities.commercial;
import java.util.List;

public interface commercialService {

    commercial savecommercial(commercial c);

    commercial updatecommercial(commercial c);

    void deletecommercial(Integer id);

    commercial getcommercial(Integer id);

    List<commercial> getAllcommercials();
}
