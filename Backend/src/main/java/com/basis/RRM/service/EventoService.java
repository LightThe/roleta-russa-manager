package com.basis.RRM.service;

import com.basis.RRM.config.*;
import com.basis.RRM.dominio.*;
import com.basis.RRM.repository.EventoRepository;
import com.basis.RRM.service.dto.*;
import com.basis.RRM.service.exception.RegraNegocioException;
import com.basis.RRM.service.mapper.EventoListarMapper;
import com.basis.RRM.service.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service
@Transactional
public class EventoService {
    private final EventoRepository eventoRepository;
    private final EventoMapper eventoMapper;
    private final EventoListarMapper eventoListarMapper;
    private final EmailService emailService;
    private final ApplicationProperties applicationProperties;

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
    @Scheduled(cron = "0 8 * * ?")
    public void enviaRotinaEmail(){
        Optional<Evento> optionalEvento = eventoRepository.findTodayEvento();

        if(optionalEvento.isPresent()) {
            List<String> copias = new ArrayList<>();
            EmailDTO emailDTO = new EmailDTO();
            Evento eventoHoje = optionalEvento.get();

            emailDTO.setAssunto("Hoje tem! um patrocinador foi escolhido na roleta russa");
            emailDTO.setCorpo("Um evento está para acontecer hoje: " +
                    eventoHoje.getNome() +
                    ". Esse evento será patrocinado por " +
                    eventoHoje.getUsuario().toArray()[0] +
                    " E mais " + (eventoHoje.getUsuario().toArray().length - 1) + " pessoas."
            );
            emailDTO.setDestinatario(applicationProperties.enderecoRemetente);

            for (Usuario u : eventoHoje.getUsuario()) {
                copias.add(u.getEmail());
            }

            emailDTO.setCopias(copias);

            emailService.enviaEmail(emailDTO);
        }
    }
}
