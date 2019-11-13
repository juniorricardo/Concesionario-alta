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
	
	
	

	/**
	 * 
	 * @param enModelo Es el modelo que se desea filtrar
	 * @return 'regLista' Es la lista luego de realizar el filtro, del modelo solo
	 *         si 'enModelo' no es nulo o vacia.
	 */
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
	}

	/**
	 * Cargar a la "base de datos" un nuevo vehiculo
	 * 
	 * @param nuevo Es el objeto vehiculo que se envia desde el controlador
	 */
	public void setVehiculo(Vehiculo nuevo) {
		RegistroVehiculos.setVehiculo(nuevo);
	}

}
