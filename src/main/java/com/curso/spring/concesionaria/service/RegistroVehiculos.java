package com.curso.spring.concesionaria.service;

import java.util.HashMap;

public class RegistroVehiculos {

    private static HashMap<Integer,Vehiculo> miRegistro;
    private static int ultimoId;
    
    static{
        miRegistro = new HashMap<>();
        miRegistro.put(1, new Vehiculo("Volkswagen","Gol",200));
        miRegistro.put(2,new Vehiculo("Ford","Fiesta Kinetic",219));
        ultimoId = 2;
    }

    public static void setVehiculo(Vehiculo enVehiculo){
        ultimoId++;
        miRegistro.put(ultimoId, enVehiculo);
    }


    public static HashMap<Integer,Vehiculo> getTabla(){
        return miRegistro;
    }

}

