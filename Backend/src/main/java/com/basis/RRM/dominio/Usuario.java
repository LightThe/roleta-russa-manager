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
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dt_nascimento")
    LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "foto")
    @Lob
    private byte[] foto;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "st_ativo")
    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;


}
