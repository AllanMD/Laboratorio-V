package com.labv.parcial1Allan.controller;

import com.labv.parcial1Allan.domain.Listados;
import com.labv.parcial1Allan.repository.ComentariosRepository;
import com.labv.parcial1Allan.repository.PublicacionesRepository;
import com.labv.parcial1Allan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/listados")
@RestController
public class ListadosController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private PublicacionesRepository publicacionesRepository;

    private Listados listados = new Listados();

    @GetMapping("/allContent")
    public void llenarListas(){

        CompletableFuture<Boolean> valor1 = listados.setListaUsuarios(usuarioRepository.findAll());
        CompletableFuture<Boolean> valor2 = listados.setListaPublicaciones(publicacionesRepository.findAll());
        CompletableFuture<Boolean> valor3 = listados.setListaComentarios(comentariosRepository.findAll());
    }

}
