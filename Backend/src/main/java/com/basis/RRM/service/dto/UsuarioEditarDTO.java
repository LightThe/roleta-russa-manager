package com.basis.RRM.service.dto;

import java.time.LocalDate;

public class UsuarioEditarDTO {
    private  Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String  email;
    private byte[] foto;
    private String telefone;
    private Boolean status;
    private SelectDTO cargo;


}
