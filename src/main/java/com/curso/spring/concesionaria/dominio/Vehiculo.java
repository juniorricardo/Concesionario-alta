package com.curso.spring.concesionaria.dominio;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Esta clase es utilizada para capturar los datos del vehiculo y poder ser manipulada
 */
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "Precio")
    private Double precio;

    public Vehiculo(){}

    public Vehiculo(String enMarca, String enModelo, Double enPrecio){
        this.marca = enMarca;
        this.modelo = enModelo;
        this.precio = enPrecio;
    }
    public void setMarca(String enMarca){
        this.marca = enMarca;
    }
    public String getMarca(){
        return this.marca;
    }

    public void setModelo(String enModelo){
        this.modelo = enModelo;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setPrecio(Double enPrecio){
        this.precio = enPrecio;
    }
    public Double getPrecio(){
        return this.precio;
    }

    @Override
    public String toString(){
        return "Vehiculo: \n" +
                "   id: " + this.id +
                "\n   Marca: " + this.marca +
                "\n   Modelo: " + this.modelo+
                "\n   Precio: " + this.precio;
    }

}
