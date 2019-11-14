package com.curso.spring.concesionaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResgistroService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Object getListVehiculos(String modelo) {
		List<Vehiculo> query;
		if (modelo.equals(null) || modelo.equals("")) {
			String sql = "select * from Autos";
			query = jdbcTemplate.query(sql, new AutoRowMapper());
		} else {
			String patron = "Select * from Autos Where modelo = '%s'";
			String filtroSql = String.format(patron, modelo);
			query = jdbcTemplate.query(filtroSql, new AutoRowMapper());
		}
		return query;

	}

	/**
	 * Cargar a la "base de datos" un nuevo vehiculo
	 * 
	 * @param nuevo Es el objeto vehiculo que se envia desde el controlador
	 */
	public void setVehiculo(Vehiculo nuevo) {
		String insertPatron = "INSERT INTO Autos(Marca, Modelo, Precio) VALUES('%s', '%s', " + nuevo.getPrecio() + ")";
		String sqlComplete = String.format(insertPatron, nuevo.getMarca(), nuevo.getModelo());
		jdbcTemplate.execute(sqlComplete);
	}

}
