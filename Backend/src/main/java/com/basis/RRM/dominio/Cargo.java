package com.basis.RRM.dominio;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "cargo")
    String cargo;
}
