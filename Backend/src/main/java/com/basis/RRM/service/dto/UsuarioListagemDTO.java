package com.basis.RRM.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioListagemDTO {
    private Long id;
    private String nome;
    private SelectDTO cargo;
}
