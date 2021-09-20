package com.basis.RRM.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioListagemDTO {
    private Long id;
    @NotBlank(message = "Nome nao pode estar em branco")
    private String nome;
    @NotNull
    private SelectDTO cargo;
}
