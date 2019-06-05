package com.labv.practicaParcial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// http://modelmapper.org/examples/flattening/#example-1

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private String playerName;
    private String playerLast_Name;
    private String playerAge;
    private String teamName;

}
