package com.example.employservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

    @GetMapping("/dipendente")
    public String getEmploy(){
        return "Giorgio Basile";
    }

}
