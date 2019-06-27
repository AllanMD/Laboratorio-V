package com.labv.parcial1Allan.repository;

import com.labv.parcial1Allan.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Integer> {
}
