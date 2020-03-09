package com.curso.spring.concesionaria.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empleado_permiso")
@Getter @Setter @NoArgsConstructor
public class Empleado_Permiso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_permiso")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_empleado")
    private Empleado empleado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_permiso")
    private Permiso permiso;

    private String comentario;

}

