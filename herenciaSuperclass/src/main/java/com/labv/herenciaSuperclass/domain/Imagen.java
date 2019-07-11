package com.labv.herenciaSuperclass.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imagen extends Contenido {

    private String URL;
}
