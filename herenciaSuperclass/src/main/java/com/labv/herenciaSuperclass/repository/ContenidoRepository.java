package com.labv.herenciaSuperclass.repository;

import com.labv.herenciaSuperclass.domain.Contenido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ContenidoRepository {

    public List<Contenido> contenidos = new ArrayList<>();

    public void add (Contenido c){
        contenidos.add(c);
    }

    public List<Contenido> readAll (){
        return contenidos.stream().collect(Collectors.toList());
    }

}
