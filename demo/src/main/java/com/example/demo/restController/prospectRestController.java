package com.example.demo.restController;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/api/prospects")
public class prospectRestController {

    private final prospectService prospectService;
    private final commercialService commercialService;

    public prospectRestController(prospectService prospectService,
            commercialService commercialService) {
        this.prospectService = prospectService;
        this.commercialService = commercialService;
    }

    // GET ALL
    @GetMapping
    public List<prospect> getAllProspects() {
        return prospectService.getAllprospects();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public prospect getProspectById(@PathVariable Integer id) {
        return prospectService.getprospect(id);
    }

    // ADD
    @PostMapping
    public prospect addProspect(@RequestBody prospect p) {
        return prospectService.saveprospect(p);
    }

    // UPDATE
    @PutMapping
    public prospect updateProspect(@RequestBody prospect p) {
        return prospectService.updateprospect(p);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteProspect(@PathVariable Integer id) {
        prospectService.deleteprospect(id);
    }

    @PostMapping("/by-commercial")
    public List<prospect> getProspectsByCommercial(@RequestBody commercial c) {

        commercial realCommercial = commercialService.getcommercial(c.getIdCommercial());

        if (realCommercial == null) {
            return List.of();
        }
        return prospectService.findByCommercial(realCommercial);
    }

    @RequestMapping(value = "/prodsByName/{nom}", method = RequestMethod.GET)
    public List<prospect> findByNomProspectContains(@PathVariable("nom") String nom) {
        return prospectService.findByNomProspectContains(nom);
    }

}
