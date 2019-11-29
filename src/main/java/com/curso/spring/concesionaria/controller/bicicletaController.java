package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.dominio.Bicicleta;
import com.curso.spring.concesionaria.repository.IBicicletaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bicicleta")
public class bicicletaController {

    @Autowired
    IBicicletaRepo repo;

    //http://localhost:8080/bicicleta/
    @GetMapping("/")
    public ResponseEntity<Bicicleta> getAllBicicleta(Model modelo) {
        List<Bicicleta> bicicletas = repo.findAll();
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }

   /* @GetMapping("bicicleta/{marca}")
    public String mostrarMarca(@PathVariable(name="marca",value = "") String marca){
        return "bicicletas";
    }

    @GetMapping("bicicletas/{marca}/{modelo}")
    public String mostrarMarcaModelo(@PathVariable(name="marca",value = "") String marca,
                                     @PathVariable(name="modelo",value = "") String modelo){
        return "bicicletas";
    }*/
}