package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.domain.Empleado;
import com.curso.spring.concesionaria.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @GetMapping({"/",""})
    public List<Empleado> listarEmpleados(){

        return empleadoRepository.findAll();
    }

}
