package com.basis.RRM.web.rest;

import com.basis.RRM.service.EventoService;
import com.basis.RRM.service.dto.EventoDTO;
import com.basis.RRM.service.dto.EventoListarDTO;
import com.basis.RRM.service.filter.EventoFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/evento")
@RequiredArgsConstructor
public class EventoResource {
    private final EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoListarDTO>> exibirEventos(){
        return ResponseEntity.ok(eventoService.mostrarTodosEventos());
    }
    @GetMapping("/filtro")
    public ResponseEntity<List<EventoListarDTO>> filtrarEventos(@RequestBody EventoFilter evento){
        return ResponseEntity.ok(eventoService.filtrarEventos(evento));
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoDTO> exibirEventoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventoService.mostrarEventoPorId(id));
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvarEvento(@Valid@RequestBody EventoDTO eventoDTO){
        return ResponseEntity.ok(eventoService.salvarEvento(eventoDTO));
    }

    @PutMapping
    public ResponseEntity<EventoDTO> editarEvento(@Valid @RequestBody EventoDTO eventoDTO){
        return ResponseEntity.ok(eventoService.salvarEvento(eventoDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EventoDTO> cancelarEvento(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventoService.cancelarEvento(id));
    }
    //TODO: @DeleteMapping
}
