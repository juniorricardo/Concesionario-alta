package com.curso.spring.concesionaria.service;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int precio;

    public Vehiculo(){}

    public Vehiculo(String enMarca, String enModelo, int enPrecio){
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
    public void setPrecio(int enPrecio){
        this.precio = enPrecio;
    }
    public int getPrecio(){
        return this.precio;
    }

}
