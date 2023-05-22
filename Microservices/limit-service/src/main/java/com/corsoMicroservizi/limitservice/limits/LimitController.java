package com.corsoMicroservizi.limitservice.limits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @GetMapping("/limits")
    public Limits getLimits() {
        return new Limits(2, 100);
    }
}
