package com.basis.RRM.service.dto;

import com.basis.RRM.dominio.Motivo;
import com.basis.RRM.dominio.Situacao;
import com.basis.RRM.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EventoEditarDTO {

    private Long id;
    private String nome;
    private LocalDate data;
    private String justificativa;
    private Double valor;

    //private SelectDTO motivo;
    //private SelectDTO situacao;
    //private List<Usuario> usuario;
}
