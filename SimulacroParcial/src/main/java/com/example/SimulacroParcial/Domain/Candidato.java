package com.example.SimulacroParcial.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidato {

    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private LocalDate fecha;
    //fecha

    @PrePersist // ejecuta esto antes de guardar el candidato
    public void agregarFecha(){
        if (this.fecha == null){
            this.fecha = LocalDate.now();
        }
    }

}
