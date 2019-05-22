package com.example.SimulacroParcial.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class Health {

    /**
     *
     * @return status of the microservices.
     */
    @GetMapping("")
    public String getHealth() {
        return "Status Alive adsad";
    }


}
