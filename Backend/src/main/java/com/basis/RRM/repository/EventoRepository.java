package com.basis.RRM.repository;

import com.basis.RRM.dominio.Evento;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("select new com.basis.RRM.service.dto.EventoDTO evento" +
            "from Evento e" +
            "where evento.data = current_date")
    Optional<Evento> findTodayEvento();
}
