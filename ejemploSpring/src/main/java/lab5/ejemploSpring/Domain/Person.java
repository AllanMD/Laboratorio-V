package lab5.ejemploSpring.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
}


// DESCARGAR POSTMAN PARA QUE TODO FUNCIONE