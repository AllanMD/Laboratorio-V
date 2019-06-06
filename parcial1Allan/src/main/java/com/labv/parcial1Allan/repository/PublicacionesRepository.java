package com.labv.parcial1Allan.repository;

import com.labv.parcial1Allan.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicacion, Integer> {
}
