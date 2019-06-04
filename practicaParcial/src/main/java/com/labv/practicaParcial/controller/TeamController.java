package com.labv.practicaParcial.controller;


import com.labv.practicaParcial.domain.Team;
import com.labv.practicaParcial.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/teams")
@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("")
    public void create (@RequestBody Team team){
        teamRepository.save(team);
    }

    @GetMapping("")
    public List<Team> readAll(){
        return teamRepository.findAll();
    }


}
