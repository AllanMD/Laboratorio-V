package com.labv.parcial1Allan.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labv.parcial1Allan.controller.ComentarioController;
import com.labv.parcial1Allan.repository.ComentariosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Timer;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comentario {

    @Id @GeneratedValue
    private int id;
    private String descripcion;
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @JsonIgnore // esto no para mostrar el usuario que hizo el comentario
    private Usuario owner;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comentario", referencedColumnName = "id")
    @JsonIgnore
    private Publicacion publicacion;


    static int TIEMPO_LIMITE;

    @Scheduled(fixedRate = TIEMPO_LIMITE)
    public void eliminarComentariosSchedule (){

        ComentarioController comentarioController = new ComentarioController();
            comentarioController.deleteComentario(id);
    }

}
