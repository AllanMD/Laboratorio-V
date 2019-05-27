package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.Domain.Candidato;
import com.example.SimulacroParcial.Domain.Voto;
import com.example.SimulacroParcial.Repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.PrePersist;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/candidatos")
@RestController
public class CandidatoController {

    private static final String PERSON_NOT_FOUND = "No existe el candidato con el id: %s";

    @Autowired
    private CandidatoRepository candidatoRepository;

    @PostMapping("")
    //@PrePersist creo que no va aca
    public void agregar(@RequestBody Candidato c) {
        candidatoRepository.save(c);
    }

    @GetMapping("")
    public List<Candidato> getAll() {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        candidatos = candidatoRepository.findAll();

        return candidatos;
    }

    @GetMapping("/{id}")
    public Candidato getCandidato(@PathVariable Integer id) {
        Candidato c = candidatoRepository.findById(id).orElse(null);
        return c;
    }

    @PostMapping("/{id}/vote")
    public void votarCandidato(@PathVariable final Integer id, @RequestBody final Voto voto) {
        Candidato c = candidatoRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND, id)));
        c.getVotos().add(voto);
        voto.setCandidato(c);
        candidatoRepository.save(c); // persistencia
    }

    @GetMapping("/votes")
    public void candidatosConVotos() {
        // devolver candidatos con sus votos
        // ya lo hace el metodo getAll()
    }
}
