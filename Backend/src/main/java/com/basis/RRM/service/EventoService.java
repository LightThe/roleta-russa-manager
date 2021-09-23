package com.basis.RRM.service;

import com.basis.RRM.config.*;
import com.basis.RRM.dominio.*;
import com.basis.RRM.repository.EventoRepository;
import com.basis.RRM.service.dto.*;
import com.basis.RRM.service.exception.RegraNegocioException;
import com.basis.RRM.service.filter.EventoFilter;
import com.basis.RRM.service.mapper.EventoListarMapper;
import com.basis.RRM.service.mapper.EventoMapper;
import liquibase.pro.packaged.D;
import liquibase.pro.packaged.L;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
        return eventoListarMapper.toDto(eventoRepository.findAllOrderDate());
//        return eventoListarMapper.toDto(eventoRepository.findAll());
        //TODO: não trazer os cancelados
    }
    public List<EventoListarDTO> filtrarEventos(EventoFilter filter){
        return eventoListarMapper.toDto(eventoRepository.findAll(filter.filtrar()));
    }

    public EventoDTO mostrarEventoPorId(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não existe"));
        return eventoMapper.toDto(evento);
    }

    public EventoDTO salvarEvento(EventoDTO dto){
        Evento evento = eventoMapper.toEntity(dto);
        if (eventoRepository.existsByDataEvento(evento.getDataEvento())){
            throw new RegraNegocioException("Já existe um evento marcado nessa data");
        }
        Evento eventoSalvo = eventoRepository.save(evento);
        return eventoMapper.toDto(eventoSalvo);
    }


    public EventoDTO cancelarEvento(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Evento não existe"));
        Situacao situacao = new Situacao();
        situacao.setId(3L);
        evento.setSituacao(situacao);
        return eventoMapper.toDto(eventoRepository.save(evento));
    }

    //@Scheduled(cron = "0 12 16 * * ?")
    public void enviaRotinaEmail(){
//        Optional<Evento> optionalEvento = eventoRepository.findTodayEvento(LocalDate.now());

        EmailDTO teste = new EmailDTO();
        teste.setCorpo("Teste do email automatico que deveria funcionar");
        teste.setDestinatario(applicationProperties.enderecoRemetente);
        teste.setAssunto("Assunto Teste");
        teste.setCopias(Collections.singletonList("gallotheo@gmail.com"));
        emailService.enviaEmail(teste);
        System.out.println("Enviou o Email de teste!");

//        if(optionalEvento.isPresent()) {
//            List<String> copias = new ArrayList<>();
//            EmailDTO emailDTO = new EmailDTO();
//            Evento eventoHoje = optionalEvento.get();
//
//            emailDTO.setAssunto("Hoje tem! um patrocinador foi escolhido na roleta russa");
//            emailDTO.setCorpo("Um evento está para acontecer hoje: " +
//                    eventoHoje.getNome() +
//                    ". Esse evento será patrocinado por " +
//                    eventoHoje.getUsuario().toArray()[0] +
//                    " E mais " + (eventoHoje.getUsuario().toArray().length - 1) + " pessoas."
//            );
//            emailDTO.setDestinatario(applicationProperties.enderecoRemetente);
//
//            for (Usuario u : eventoHoje.getUsuario()) {
//                copias.add(u.getEmail());
//            }
//
//            emailDTO.setCopias(copias);
//
//            emailService.enviaEmail(emailDTO);
//            System.out.println("Enviou o email!\n");
//        }
    }
}
