package com.example.SimulacroParcial.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // prepara la clase para poder guardarse en bd??
public class Candidato {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidato") // PREGUNTAR
    private List<Voto> votos;


    //fetch lazy trae de la bd los datos del objeto, y crea una referencia a los objetos o a la lista de objetos
    // en caso de necesitar alguno de esos objetos, mediante la referencia va y los busca
    // fectch eagle trae todo, tanto datos como lista de objetos

}
