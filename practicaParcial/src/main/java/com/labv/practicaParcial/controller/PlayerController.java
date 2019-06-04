package com.labv.practicaParcial.controller;

import com.labv.practicaParcial.domain.Player;
import com.labv.practicaParcial.domain.Team;
import com.labv.practicaParcial.repository.PlayerRepository;
import com.labv.practicaParcial.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RequestMapping("/players")
@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/{team_id}")
    public void create(@RequestBody Player p, @PathVariable Integer team_id) {
        Team t = teamRepository.findById(team_id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "No existe un equipo con el id: " + team_id));
        p.setTeam(t);
        t.add(p);
        //teamRepository.save(t);
        playerRepository.save(p);
    }

    @GetMapping("{id}")
    public Player read(@PathVariable Integer id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "No se encontro el Jugador con el ID:" + id)); // or else
    }

    @GetMapping("")
    public List<Player> readAllPlayers(@RequestHeader HttpHeaders header) {
        System.out.println("HEADERRRRRRRRRRRRRRR:" + header.getHost()); // poner breakpoint aca y probar con debug y calculadora
        return playerRepository.findAll();
    }

    public void updatePlayer (){

    }

    @DeleteMapping("/delete/{id}") // o GetMapping
    public void deletePlayer (@PathVariable Integer id){
        playerRepository.deleteById(id);

    }

}
