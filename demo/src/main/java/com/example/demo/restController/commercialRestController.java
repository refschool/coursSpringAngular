package com.example.demo.restController;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.commercial;
import com.example.demo.entities.utilisateur;
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

    @PostMapping(path = "/addcommercial")
    public commercial createCommercial(@RequestBody commercial c) {
        return cService.savecommercial(c);
    }

    @PutMapping(path = "/updatecommercial")
    public commercial updateCommercial(@RequestBody commercial c) {
        return cService.updatecommercial(c);
    }

    @DeleteMapping("deletecommercial")
    public void deleteCommercial(@PathVariable("id") int id) {
        cService.deletecommercial(id);
    }
}
