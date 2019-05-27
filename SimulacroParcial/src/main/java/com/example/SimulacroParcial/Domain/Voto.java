package com.example.SimulacroParcial.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // generated value: auto incremental para el id
    // strategy: de que forma va a ser el autoincrementar
    // es lo mismo que no poner strategy = ... ya que generated value usa por defecto IDENTITY
    private Integer id;
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    @JsonIgnore
    private Candidato candidato;


    @PrePersist // ejecuta esto antes de guardar el candidato
    public void agregarFecha() {
        if (this.fecha == null) {
            this.fecha = LocalDateTime.now();
        }
    }

}
