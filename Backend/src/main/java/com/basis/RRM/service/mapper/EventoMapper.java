package com.basis.RRM.service.mapper;

import com.basis.RRM.dominio.Evento;
import com.basis.RRM.service.dto.EventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoSelectMapper.class, UsuarioListagemMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento> {

}
