package com.curso.spring.concesionaria.domain;

import javax.persistence.*;

@Entity
@Table(name = "bicicletas")
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="marca")
    private String marca;

    @Column(name="modelo")
    private String modelo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString(){
        return  "Bicicleta: \n" +
                "\tid: " + getId() +
                "\t\tMarca: " + getMarca() +
                "\t\tModelo: " + getModelo() ;
    }
}