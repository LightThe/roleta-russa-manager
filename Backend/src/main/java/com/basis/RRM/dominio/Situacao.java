package com.basis.RRM.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "situacao")
@Getter
@Setter
public class Situacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private  Long id;

    @Column(name = "situacao")
    private String situacao;


}
