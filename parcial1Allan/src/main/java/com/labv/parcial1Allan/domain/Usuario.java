package com.labv.parcial1Allan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id @GeneratedValue
    private int id;
    private String nombre;
    private String apellido;
    private String browser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Publicacion> publicaciones;


    public void add(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }
}
