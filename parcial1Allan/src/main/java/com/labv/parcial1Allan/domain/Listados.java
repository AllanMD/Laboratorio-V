package com.labv.parcial1Allan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listados {

    private List<Usuario> usuarios;
    private List<Publicacion> publicaciones;
    private List<Comentario> comentarios;

    @Async("Executor")
    public CompletableFuture<Boolean> setListaUsuarios (List<Usuario> usuarios){
        try {
            this.usuarios = usuarios;
            Thread.sleep(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(true);
    }

    @Async("Executor")
    public CompletableFuture<Boolean> setListaPublicaciones (List<Publicacion> publicaciones){
        try {
            this.publicaciones = publicaciones;
            Thread.sleep(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(true);
    }

    @Async("Executor")
    public CompletableFuture<Boolean> setListaComentarios (List<Comentario> comentarios){
        try {
            this.comentarios = comentarios;
            Thread.sleep(200);
        } catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(true);
    }
}
