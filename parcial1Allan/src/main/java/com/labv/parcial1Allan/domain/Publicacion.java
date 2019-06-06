package com.labv.parcial1Allan.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publicacion {

    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private String descripcion;
    private String foto;
    private LocalDate fechaPublicacion;
    private Integer liked;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publicacion", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    public void add(Comentario comentario) {
        comentarios.add(comentario);
    }
}
