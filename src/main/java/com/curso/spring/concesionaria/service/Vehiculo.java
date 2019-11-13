package com.curso.spring.concesionaria.service;

/**
 * Esta clase es utilizada para capturar los datos del vehiculo y poder ser manipulada
 */
public class Vehiculo {

    private String marca;
    private String modelo;
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

}
