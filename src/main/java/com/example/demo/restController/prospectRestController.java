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

    @PostMapping("/by-commercial")
    public List<prospect> getProspectsByCommercial(@RequestBody commercial c) {

        commercial realCommercial = commercialService.getcommercial(c.getIdCommercial());

        if (realCommercial == null) {
            return List.of();
        }
        return prospectService.findByCommercial(realCommercial);
    }
}
