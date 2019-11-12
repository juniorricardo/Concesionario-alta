package com.curso.spring.concesionaria.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ResgistroService {

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

    public void setVehiculo(Vehiculo nuevo){
        RegistroVehiculos.setVehiculo(nuevo);
    }
    
}
