package com.example.demo.restController;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.commercialService;

@RestController
@RequestMapping("/api/commercials")
public class commercialRestController {

    private final commercialService cService;

    public commercialRestController(commercialService commercialService) {
        this.cService = commercialService;
    }

}
