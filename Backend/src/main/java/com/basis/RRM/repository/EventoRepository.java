package com.basis.RRM.repository;

import com.basis.RRM.dominio.Evento;
import com.basis.RRM.service.dto.EventoDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("select e " +
            "from Evento e " +
            "where e.dataEvento = :data")
    Optional<Evento> findTodayEvento(@Param("data") LocalDate data);
}
