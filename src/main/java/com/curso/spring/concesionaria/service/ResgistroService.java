package com.curso.spring.concesionaria.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ResgistroService {

    /**
     * 
     * @param enModelo Es el modelo que se desea filtrar
     * @return 'regLista' Es la lista luego de realizar el filtro, del modelo solo si
     *                    'enModelo' no es nulo o vacia.
     */
	public ArrayList<Vehiculo> getListaVehiculos(String enModelo){

        ArrayList<Vehiculo> regLista = new ArrayList<>();
        HashMap<Integer,Vehiculo> regService = RegistroVehiculos.getTabla();
        Set<Integer> keys = regService.keySet();

        if(enModelo.equals(null) || enModelo.equals("")){
            for (Integer key : keys) 
                regLista.add(regService.get(key));
        }
        else{
            for (Integer key : keys) {
                if(regService.get(key).getModelo().equals(enModelo))
                    regLista.add(regService.get(key));
            }
        }
        return regLista;
    }

    /**
     * Cargar a la "base de datos" un nuevo vehiculo
     * @param nuevo Es el objeto vehiculo que se envia desde el controlador
     */
    public void setVehiculo(Vehiculo nuevo){
        RegistroVehiculos.setVehiculo(nuevo);
    }
    
}
