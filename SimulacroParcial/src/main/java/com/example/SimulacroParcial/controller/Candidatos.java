package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.Domain.Candidato;
import com.example.SimulacroParcial.Repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/candidatos")
@RestController
public class Candidatos {

    @Autowired
    private CandidatoRepository cRepository;

    @PostMapping("")
    @PrePersist
    public void agregar (@RequestBody Candidato c){
        cRepository.save(c);
    }

    @GetMapping("")
    public List<Candidato> getAll (){
        List<Candidato> candidatos = new ArrayList<Candidato>();
        candidatos = cRepository.findAll();

        return candidatos;
    }

    @GetMapping("/{id}")
    public Candidato getCandidato (@PathVariable Integer id){
        Candidato c = cRepository.findById(id);
        return c;
    }
}
