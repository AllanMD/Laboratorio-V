package com.labv.parcial1Allan.controller;


import com.labv.parcial1Allan.domain.Comentario;
import com.labv.parcial1Allan.domain.Publicacion;
import com.labv.parcial1Allan.repository.ComentariosRepository;
import com.labv.parcial1Allan.repository.PublicacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RequestMapping("/comentarios")
@RestController
public class ComentarioController {

    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private PublicacionesRepository publicacionesRepository;

    @PostMapping("/publicacion/{id_publicacion}")
    public void createComentario(@RequestBody Comentario comentario, @PathVariable int id_publicacion){
        Publicacion p = publicacionesRepository.findById(id_publicacion)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "No se encontro la publicacion con el ID:" + id_publicacion));

        comentario.setPublicacion(p);
        p.add(comentario);

        comentariosRepository.save(comentario);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteComentario (@PathVariable Integer id){
        comentariosRepository.deleteById(id);

    }


}
