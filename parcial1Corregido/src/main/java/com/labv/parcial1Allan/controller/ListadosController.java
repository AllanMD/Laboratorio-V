package com.labv.parcial1Allan.controller;

import com.labv.parcial1Allan.domain.Comentario;
import com.labv.parcial1Allan.domain.Listados;
import com.labv.parcial1Allan.domain.Publicacion;
import com.labv.parcial1Allan.domain.Usuario;
import com.labv.parcial1Allan.service.ListadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/listados")
@RestController
public class ListadosController {

    @Autowired
    ListadoService listadoService;

    private Listados listados = new Listados();

    @GetMapping("/allContent")
    public Listados retornarListado(){

        CompletableFuture<List<Usuario>> valor1 = listadoService.getListaUsuarios();
        CompletableFuture<List<Publicacion>> valor2 = listadoService.getListaPublicaciones();
        CompletableFuture<List<Comentario>> valor3 = listadoService.getListaComentarios();

        Listados listado = new Listados(valor1.join(), valor2.join(), valor3.join()); // el join es lo que hace que el metodo funcione de forma asincrona
        // el join lo que hace es esperar al resultado de la promesa, si no pongo join, el valor va a ser un objeto de tipo promesa.
        return listado;

    }

}
