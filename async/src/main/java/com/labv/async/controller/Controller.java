package com.labv.async.controller;

import com.labv.async.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    Service1 service1;
    @GetMapping("/suma")
    ResponseEntity<?> getSuma (){
        CompletableFuture<Integer> valor1 = service1.metodo1();
        CompletableFuture<Integer> valor2 = service1.metodo2();

        return ResponseEntity.status(200).body(valor1.join() + valor2.join()); // retorna la suma de los 2 valores
    }

}
