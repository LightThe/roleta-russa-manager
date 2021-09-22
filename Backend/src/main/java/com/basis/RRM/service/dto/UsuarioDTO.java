package com.basis.RRM.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {

    private  Long id;
    @NotBlank(message = "Nome nao pode estar em branco")
    private String nome;
    @CPF
    private String cpf;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @Email(message = "E-mail já existe")
    private String  email;
    private byte[] foto;
    private String telefone;
    @NotNull
    private Boolean status;
    @NotNull
    private SelectDTO cargo;
}
