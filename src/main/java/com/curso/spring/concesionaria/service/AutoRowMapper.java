package com.curso.spring.concesionaria.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.curso.spring.concesionaria.dominio.Vehiculo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class AutoRowMapper implements RowMapper<Vehiculo> {

	@Override
	public Vehiculo mapRow(ResultSet resultadoSet, int i) throws SQLException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca(resultadoSet.getString("marca"));
		vehiculo.setModelo(resultadoSet.getString("modelo"));
		vehiculo.setPrecio(resultadoSet.getDouble("precio"));
		return vehiculo;
	}

}
