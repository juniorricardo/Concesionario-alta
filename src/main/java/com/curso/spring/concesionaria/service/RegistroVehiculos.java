package com.curso.spring.concesionaria.service;

import java.util.HashMap;

public class RegistroVehiculos {

    private static HashMap<Integer, Vehiculo> miRegistro;
    private static int ultimoId;

    static {
        miRegistro = new HashMap<>();
//        miRegistro.put(1, new Vehiculo("Volkswagen", "Amarok", 1500000));
//        miRegistro.put(2, new Vehiculo("Volkswagen", "Vento", 1380000));
//        miRegistro.put(3, new Vehiculo("Volkswagen", "Polo", 932000));
//        miRegistro.put(4, new Vehiculo("FIAT", "500", 1000000));
//        miRegistro.put(5, new Vehiculo("FIAT", "Toro", 1240000));
//        miRegistro.put(6, new Vehiculo("FIAT", "Palio", 700000));
//        miRegistro.put(7, new Vehiculo("FIAT", "Punto", 600000));
//        miRegistro.put(8, new Vehiculo("Citroen", "DS3", 2450000));
//        miRegistro.put(9, new Vehiculo("Citroen", "Cactus", 984000));
//        miRegistro.put(10, new Vehiculo("Peugeot", "5008", 243500));
//        miRegistro.put(11, new Vehiculo("Peugeot", "208", 700000));
//        miRegistro.put(12, new Vehiculo("Peugeot", "408", 845000));
        ultimoId = 13;
    }

    public static void setVehiculo(Vehiculo enVehiculo) {
        ultimoId++;
        miRegistro.put(ultimoId, enVehiculo);
    }

    public static HashMap<Integer, Vehiculo> getTabla() {
        return miRegistro;
    }

}
