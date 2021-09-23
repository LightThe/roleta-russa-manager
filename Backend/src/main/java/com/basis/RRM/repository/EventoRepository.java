package com.basis.RRM.repository;

import com.basis.RRM.dominio.Evento;
import com.basis.RRM.dominio.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import com.basis.RRM.dominio.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>, JpaSpecificationExecutor<Evento>{

    @Query("select new com.basis.RRM.service.dto.EventoDTO evento" +
            "from Evento e" +
            "where evento.data = current_date")
    Optional<Evento> findTodayEvento();

    Optional<Evento> findByMotivo(Motivo motivo);
    boolean existsByDataEvento(LocalDate dataEvento);

    @Query("SELECT obj from Evento obj ORDER BY obj.dataEvento")
    List<Evento> findAllOrderDate();
}
