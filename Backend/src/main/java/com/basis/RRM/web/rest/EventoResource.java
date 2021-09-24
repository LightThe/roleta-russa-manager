package com.basis.RRM.web.rest;

import com.basis.RRM.service.EventoService;
import com.basis.RRM.service.dto.EventoDTO;
import com.basis.RRM.service.dto.EventoListarDTO;
import com.basis.RRM.service.filter.EventoFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/evento")
@RequiredArgsConstructor
public class EventoResource {
    private final EventoService eventoService;


    @GetMapping("/filtro")
    public ResponseEntity<List<EventoListarDTO>> filtrarEventos(EventoFilter evento){
        return ResponseEntity.ok(eventoService.filtrarEventos(evento));
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoDTO> exibirEventoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventoService.mostrarEventoPorId(id));
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvarEvento(@Valid @RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.salvarEvento(eventoDTO));
    }

    @PutMapping
    public ResponseEntity<EventoDTO> editarEvento(@Valid @RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.editarEvento(eventoDTO));
    }
    @PutMapping("/adiar/{id}")
    public ResponseEntity<Void> adiarEvento(@PathVariable("id") Long id){
        eventoService.adiarEvento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/trocar/{idPri}/{idSec}")
    public ResponseEntity<Void> trocarDataDeEventos(@PathVariable("idPri")Long idPri,@PathVariable("idSec") Long idSec){
        eventoService.trocarEventosDeData(idPri,idSec);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> cancelarEvento(@PathVariable("id") Long id) {
        eventoService.cancelarEvento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/email")
    public ResponseEntity<Void> enviarEmail(){
        eventoService.enviaRotinaEmail();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
