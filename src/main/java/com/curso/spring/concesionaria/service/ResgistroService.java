package com.curso.spring.concesionaria.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ResgistroService {

	public ArrayList<Vehiculo> getListaVehiculos(){
        ArrayList<Vehiculo> regLista = new ArrayList<>();
        HashMap<Integer,Vehiculo> regService = RegistroVehiculos.getTabla();
        Set<Integer> keys = regService.keySet();
        for (Integer key : keys) 
            regLista.add(regService.get(key));
        return regLista;
    }

    public void setVehiculo(Vehiculo nuevo){
        RegistroVehiculos.setVehiculo(nuevo);
    }

    public ArrayList<Vehiculo> getListaModelo(String modelo){
        
        ArrayList<Vehiculo> regLista = new ArrayList<>();
        HashMap<Integer,Vehiculo> regService = RegistroVehiculos.getTabla();
        Set<Integer> keys = regService.keySet();
        
        for (Integer key : keys) {
            if(regService.get(key).getModelo().equals(modelo))
                regLista.add(regService.get(key));
        }
        if (regLista.size() == 0)
            return null;

        return regLista;
    }

    
}
