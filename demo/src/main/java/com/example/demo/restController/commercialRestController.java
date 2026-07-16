package com.example.demo.restController;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.commercial;
import com.example.demo.service.commercialService;

@RestController
@RequestMapping("/api/commercials")
public class commercialRestController {

    private final commercialService cService;

    public commercialRestController(commercialService commercialService) {
        this.cService = commercialService;
    }

    @GetMapping
    public List<commercial> getAllCommercials() {
        return cService.getAllcommercials();
    }

    @GetMapping("/{id}")
    public commercial getCommercialById(@PathVariable Integer id) {
        return cService.getcommercial(id);
    }

}
