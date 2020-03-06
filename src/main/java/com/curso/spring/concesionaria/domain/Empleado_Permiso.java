package com.curso.spring.concesionaria.domain;

import javax.persistence.*;

@Entity
public class Empleado_Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comentario")
    private String comentario;
}
