package com.labv.practicaParcial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "team") //un equipo puede tener muchos jugadores
    // mappedby : lo mapea por el atributo "team" de Player
    private List<Player> players;

    public void add (Player p){
        players.add(p);
    }
}
