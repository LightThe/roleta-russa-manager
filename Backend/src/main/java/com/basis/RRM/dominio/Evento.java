package com.basis.RRM.dominio;

import liquibase.pro.packaged.J;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "nome")
    private String nome;

    @Column(name = "data")
    private LocalDate dataEvento;

    @Column(name = "justificativa")
    private String justificativa;

    @Column(name = "valor")
    private Double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_motivo")
    private Motivo motivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_situacao")
    private Situacao situacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_evento", joinColumns = {
            @JoinColumn(name="id_evento")
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_usuario")
    })
    private List<Usuario> usuario;
    //data, justificativa, valor, motivo, situacao


}
