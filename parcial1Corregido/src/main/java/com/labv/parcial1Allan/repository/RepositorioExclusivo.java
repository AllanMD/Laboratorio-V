package com.labv.parcial1Allan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// punto 2:
public interface RepositorioExclusivo extends JpaRepository<ComentariosPorPublicacionesDTO, Integer> {

    String NATIVE_QUERY = "select p.titulo, u.nombre, count(c.id) as cantidad FROM publicacion p inner join usuario u on p.id = u.id_publicacion inner join comentario c on p.id = c.id_comentario group by p.titulo, u.nombre";

    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<ComentariosPorPublicacionesDTO> getComentariosPorPublicacionesDTO ();
}
