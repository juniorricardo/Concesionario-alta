package com.curso.spring.concesionaria.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Esta clase es utilizada para capturar los datos del vehiculo y poder ser
 * manipulada
 */
@Entity
@Table(name = "autos")
public class Auto implements Serializable{

	private static final long serialVersionUID = 125813037740879154L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "marca")
	private String marca;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "precio")
	private Double precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecio() {
		return this.precio;
	}

	@Override
	public String toString() {
		return "Auto: \n" + "   id: " + this.id +
				"\n   Marca: " + this.marca +
				"\n   Modelo: " + this.modelo +
				"\n   Precio: " + this.precio;
	}

}
