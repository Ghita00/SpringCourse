package com.example.andressservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @GetMapping("/indirizzo")
    public String getAddress(){
        return "via carreri 1b";
    }
}
