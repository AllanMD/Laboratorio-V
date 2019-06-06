package com.labv.parcial1Allan.controller;


import com.labv.parcial1Allan.domain.Publicacion;
import com.labv.parcial1Allan.domain.Usuario;
import com.labv.parcial1Allan.repository.PublicacionesRepository;
import com.labv.parcial1Allan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RequestMapping("/publicaciones")
@RestController
public class PublicacionController {

    @Autowired
    private PublicacionesRepository publicacionesRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuario/{id_usuario}")
    public void createPublicacion(@RequestBody Publicacion publicacion, @PathVariable int id_usuario){
        Usuario user = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "No se encontro el usuario con el ID:" + id_usuario));

        publicacion.setUsuario(user);
        user.add(publicacion);

        publicacionesRepository.save(publicacion);
    }


    @GetMapping("")
    public List<Publicacion> readAllPublicaciones(){
        return publicacionesRepository.findAll();
    }
}
