package com.basis.RRM.service.dto;

import com.basis.RRM.dominio.Motivo;
import com.basis.RRM.dominio.Situacao;
import com.basis.RRM.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EventoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Future
    private LocalDate data;

    private String justificativa;

    @NotBlank
    private Double valor;

//    @NotNull
//    private SelectDTO motivo;
    @NotNull
    private SelectDTO situacao;
    @NotNull
    private List<Usuario> usuario;
}
