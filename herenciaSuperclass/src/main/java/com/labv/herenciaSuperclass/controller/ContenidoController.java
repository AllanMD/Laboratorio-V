package com.labv.herenciaSuperclass.controller;

import com.labv.herenciaSuperclass.repository.ContenidoRepository;
import com.labv.herenciaSuperclass.domain.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/contenido")
@RestController
public class ContenidoController {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @PostMapping("")
    public void add (@RequestBody Contenido c){
        System.out.println(c.getClass());
        contenidoRepository.add(c);
    }

    @GetMapping("")
    public List<Contenido> getAll (){
        return contenidoRepository.readAll();
    }

}
