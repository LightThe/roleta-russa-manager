package com.basis.RRM.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "situacao")
@Getter
@Setter
public class Situacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private  Long id;

    @Column(name = "situacao")
    private String situacao;


}
