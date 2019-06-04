package com.labv.practicaParcial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// https://www.baeldung.com/javax-validation

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue
    private int id;
    @NotNull(message = "Nombre no puede ser null") // validaciones de spring
    private String name;
    @NotNull(message = "apellido no puede ser null") // validaciones de spring
    private String last_name;
    @Min(value = 15, message = "Los jugadores no pueden ser menores de 15 años")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY) // un jugador puede estar en muchos equipos ?
    @JoinColumn(name = "id_team", referencedColumnName = "id")
    @JsonIgnore
    private Team team;
}
