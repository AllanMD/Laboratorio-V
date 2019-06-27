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

    }
