package com.labv.herenciaSuperclass.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video extends Contenido {

    private String mediaType;
    private Float peso;
}
