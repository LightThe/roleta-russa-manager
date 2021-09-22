package com.basis.RRM.service;

import com.basis.RRM.dominio.Evento;
import com.basis.RRM.repository.EventoRepository;
import com.basis.RRM.service.dto.*;
import com.basis.RRM.service.exception.RegraNegocioException;
import com.basis.RRM.service.mapper.EventoListarMapper;
import com.basis.RRM.service.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class EventoService {
    private final EventoRepository eventoRepository;
    private final EventoMapper eventoMapper;
    private final EventoListarMapper eventoListarMapper;
    private final EmailService emailService;

    public List<EventoListarDTO> mostrarTodosEventos(){
        return eventoListarMapper.toDto(eventoRepository.findAll());
        //TODO: não trazer os cancelados
    }

    public EventoDTO mostrarEventoPorId(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não existe"));
        return eventoMapper.toDto(evento);
    }

    public EventoDTO salvarEvento(EventoDTO dto){
        Evento evento = eventoMapper.toEntity(dto);
        //TODO: regra de negocio
        Evento eventoSalvo = eventoRepository.save(evento);
        return eventoMapper.toDto(eventoSalvo);
    }

    //TODO: Cancelar evento

    public void enviaRotinaEmail(){
        EmailDTO emailDTO = new EmailDTO();
        //TODO: adicionar campos no email, pegar usuario pelo agendamento, data do evento...
        emailService.enviaEmail(emailDTO);
    }
}
