package com.labv.parcial1Allan.service;

import com.labv.parcial1Allan.domain.Comentario;
import com.labv.parcial1Allan.domain.Publicacion;
import com.labv.parcial1Allan.domain.Usuario;
import com.labv.parcial1Allan.repository.ComentariosRepository;
import com.labv.parcial1Allan.repository.PublicacionesRepository;
import com.labv.parcial1Allan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

//punto 3
@Service
public class ListadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private PublicacionesRepository publicacionesRepository;

    @Async("Executor")
    public CompletableFuture<List<Usuario>> getListaUsuarios (){
        try {
            Thread.sleep(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(usuarioRepository.findAll());
    }

    @Async("Executor")
    public CompletableFuture<List<Publicacion>> getListaPublicaciones (){
        try {
            Thread.sleep(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publicacionesRepository.findAll());
    }

    @Async("Executor")
    public CompletableFuture<List<Comentario>> getListaComentarios (){
        try {
            Thread.sleep(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(comentariosRepository.findAll());
    }

}
