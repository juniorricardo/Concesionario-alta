package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.domain.Bicicleta;
import com.curso.spring.concesionaria.domain.Empleado;
import com.curso.spring.concesionaria.domain.Empleado_Permiso;
import com.curso.spring.concesionaria.domain.Permiso;
import com.curso.spring.concesionaria.repository.IEmpleadoRepository;
import com.curso.spring.concesionaria.repository.IPermisoRepository;
import com.curso.spring.concesionaria.repository.IRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modelo/api")
public class ModeloApiController {

    /*
    {
  "database": "master",
  "dialect": "MSSQL",
  "isActive": true,
  "isConnected": true,
  "name": "mySqlSever",
  "password": "damos45?",
  "port": 1433,
  "server": "localhost",
  "username": "sa"
}
     */
    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Autowired
    IPermisoRepository permisoRepository;
    @Autowired
    IRegistroRepository registroRepository;

    @GetMapping("/empleados")
    public ResponseEntity<Empleado> listarEmpleados(){
        List<Empleado> lista =  empleadoRepository.findAll();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    @GetMapping("/empleado/id/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoNombre(@PathVariable Long id){

        Optional<Empleado> empleadoEncontrado = empleadoRepository.findById(id);
        return  (empleadoEncontrado.isPresent()) ?
                new ResponseEntity(empleadoEncontrado.get(), HttpStatus.OK) :
                new ResponseEntity(HttpStatus.NOT_FOUND); /* 404 Not Found. */
    }
    @GetMapping("/empleado/nombre/{nombre}")
    public ResponseEntity<Empleado> buscarEmpleadoNombre(@PathVariable String nombre){

        Optional<Empleado> empleadoEncontrado = empleadoRepository.findAllByNombre(nombre);
        return  (empleadoEncontrado.isPresent()) ?
                new ResponseEntity(empleadoEncontrado.get(), HttpStatus.OK) :
                new ResponseEntity(HttpStatus.NOT_FOUND); /* 404 Not Found. */
    }

    @GetMapping("/permisos")
    public ResponseEntity<Permiso> listarPermisos(){
        List<Permiso> lista = permisoRepository.findAll();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/empleado-permisos")
    public ResponseEntity<Empleado_Permiso> listaRegistros(){
        List<Empleado_Permiso> lista = registroRepository.findAll();
        return new ResponseEntity(lista, HttpStatus.OK);
    }




}
