package com.labv.parcial1Allan.repository;

import com.labv.parcial1Allan.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicacion, Integer> {

    String NATIVE_QUERY = "select p.titulo, u.nombre, count(c.id) as cantidad FROM publicacion p inner join usuario u on p.id = id_publicacion inner join comentario c on p.id = id_comentario group by p.titulo, u.nombre";

    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<ComentariosPorPublicaciones> getComentariosPorPublicaciones ();



}
