package com.curso.spring.concesionaria.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "empleado_permiso")
public class Empleado_Permiso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="empleadoid")
    @JsonIgnoreProperties("empleado_permisos")
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="permisoid")
    @JsonIgnoreProperties("empleado_permisos")
    private Permiso permiso;


    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleadoid")
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permisoid")
    private Permiso permiso;*/

    private String comentario;

}

