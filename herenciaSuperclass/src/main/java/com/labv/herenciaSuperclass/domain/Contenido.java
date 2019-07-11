package com.labv.herenciaSuperclass.domain;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// https://www.baeldung.com/jackson-inheritance

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Imagen.class, name = "imagen"),
        @JsonSubTypes.Type(value = Video.class, name = "video")
}) // en el JSON se recibe un type="" para crear un objeto de tipo imagen o video
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Contenido {

    private int id;
    private String nombre;
}
