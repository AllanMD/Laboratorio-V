package com.example.SimulacroParcial.Repository;

import com.example.SimulacroParcial.Domain.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer> {
}
