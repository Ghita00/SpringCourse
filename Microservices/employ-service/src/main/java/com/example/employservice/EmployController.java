package com.example.employservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dipendente")

    public String getEmploy(){
        //get call to URL and map the resul in String type
        String indirizzo = restTemplate.getForObject("http://localhost:8080/indirizzo", String.class);
        return "Giorgio Basile " + indirizzo;
    }

}
