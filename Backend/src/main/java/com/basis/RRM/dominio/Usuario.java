package com.basis.RRM.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nome")
    String nome;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "dt_nascimento")
    LocalDate dataNascimento;

    @Column(name = "email")
    String email;

    @Column(name = "foto")
    @Lob
    byte[] foto;

    @Column(name = "telefone")
    String telefone;

    @Column(name = "st_ativo")
    Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;


}
