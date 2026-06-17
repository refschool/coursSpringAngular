package com.example.demo.service;

import java.util.List;
import com.example.demo.entities.prospect;

public interface prospectService {

    prospect saveprospect(prospect p);

    prospect updateprospect(prospect p);

    void deleteprospect(Integer id);

    prospect getprospect(Integer id);

    List<prospect> getAllprospects();

}
