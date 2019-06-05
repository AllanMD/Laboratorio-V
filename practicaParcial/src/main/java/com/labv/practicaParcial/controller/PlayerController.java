package com.labv.practicaParcial.controller;

import com.labv.practicaParcial.domain.Player;
import com.labv.practicaParcial.domain.PlayerDTO;
import com.labv.practicaParcial.domain.Team;
import com.labv.practicaParcial.repository.PlayerRepository;
import com.labv.practicaParcial.repository.TeamRepository;
import org.modelmapper.ModelMapper;
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
        //teamRepository.save(t); // al parecer no es necesario porq el playerRepository guarda tanto el player como el team, sino se guardan 2 veces los datos
        playerRepository.save(p);
    }

    @GetMapping("{id}")
    public PlayerDTO read(@PathVariable Integer id) {
        Player p = playerRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "No se encontro el Jugador con el ID:" + id)); // optional
        ModelMapper modelMapper = new ModelMapper(); //http://modelmapper.org/examples/flattening/
        PlayerDTO player = modelMapper.map(p, PlayerDTO.class);
        return player;
    }

    @GetMapping("")
    public List<Player> readAllPlayers(@RequestHeader HttpHeaders header) {
        System.out.println("HEADERRRRRRRRRRRRRRR:" + header.getHost()); // poner breakpoint aca y probar con debug y calculadora para ver lo que puede devolver header.
        return playerRepository.findAll();
    }

    @PutMapping("")
    public void updatePlayer (@RequestBody Player player){
        playerRepository.save(player); // en el JSON hay que enviar el id del que hay que modificar tambien, sino crea uno nuevo
    }

    @DeleteMapping("/delete/{id}") // o GetMapping
    public void deletePlayer (@PathVariable Integer id){
        playerRepository.deleteById(id);

    }

}
