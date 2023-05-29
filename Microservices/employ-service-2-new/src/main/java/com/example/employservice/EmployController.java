package com.example.employservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPortString;

    @Value("${server.instance.id}")
    private String instance;

    @GetMapping("/dipendente")
    public String getEmploy(){
        String indirizzo = "";
        //without Microservice: get call to URL and map the resul in String type
        indirizzo = restTemplate.getForObject("http://localhost:8080/indirizzo", String.class);
        return instance + ": Giorgio Basile "+indirizzo+" "+serverPortString;
    }

}
