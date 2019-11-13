package com.curso.spring.concesionaria.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResgistroService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Vehiculo> getNuevoAutos() {
		String sql = "select * from Autos";
		List<Vehiculo> query = jdbcTemplate.query(sql, new AutoRowMapper());
		// query.forEach(item->System.out.println(item.getMarca()));
		return query;
	}

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
//		
//		
//		String patron = "Select * from Autos Where modelo = %s";
//		String filtroSql = String.format(patron, modelo);
//		
//		List<Vehiculo> query = jdbcTemplate.query(filtroSql, new AutoRowMapper());
		return query;

	}

	/**
	 * 
	 * @param enModelo Es el modelo que se desea filtrar
	 * @return 'regLista' Es la lista luego de realizar el filtro, del modelo solo
	 *         si 'enModelo' no es nulo o vacia.
	 *
	public ArrayList<Vehiculo> getListaVehiculos(String enModelo) {

		ArrayList<Vehiculo> regLista = new ArrayList<>();
		HashMap<Integer, Vehiculo> regService = RegistroVehiculos.getTabla();
		Set<Integer> keys = regService.keySet();

		if (enModelo.equals(null) || enModelo.equals("")) {
			for (Integer key : keys)
				regLista.add(regService.get(key));
		} else {
			for (Integer key : keys) {
				if (regService.get(key).getModelo().equals(enModelo))
					regLista.add(regService.get(key));
			}
		}
		return regLista;
	} 																							*/

	/**
	 * Cargar a la "base de datos" un nuevo vehiculo
	 * 
	 * @param nuevo Es el objeto vehiculo que se envia desde el controlador
	 */
	public void setVehiculo(Vehiculo nuevo) {
		String insertPatron = "INSERT INTO Autos(Marca, Modelo, Precio) VALUES('%s', '%s', " + nuevo.getPrecio() + ")";
		String sqlComplete = String.format(insertPatron, nuevo.getMarca(), nuevo.getModelo());
		jdbcTemplate.execute(sqlComplete);

//		String values = "('nuevo.getMarca()','nuevo.getModelo()',nuevo.getPrecio() + );
//    	String sql = "INSERT INTO Autos(marca, modelo, precio) VALUES " + values;
//    	jdbcTemplate.execute(sql);
		// RegistroVehiculos.setVehiculo(nuevo);
	}

}
