package com.labv.practicaParcial.repository;

import com.labv.practicaParcial.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository <Team, Integer> {
}
