package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.dominio.Bicicleta;
import com.curso.spring.concesionaria.repository.IBicicletaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bicicletas")
public class bicicletaController {

    @Autowired
    IBicicletaRepo repo;

    //http://localhost:8080/bicicletas
    @GetMapping("/")
    public ResponseEntity<Bicicleta> getAllBicicleta(Model modelo) {
        List<Bicicleta> bicicletas = repo.findAll();
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }

    //  http://localhost:8080/bicicletas/buscar?marca=Venzo
    @GetMapping("/buscar")
    public ResponseEntity<Bicicleta> mostrarMarca(@RequestParam String marca) {
        List<Bicicleta> bicicletas = repo.findByMarcaLike("%" + marca + "%");
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }

    @GetMapping("buscar/{marca}/{modelo}")
    public ResponseEntity<Bicicleta> mostrarMarcaModelo(@PathVariable(name = "marca") String marca,
                                                        @PathVariable(name = "modelo") String modelo) {
        Bicicleta bicicletas = repo.find2(marca, "%" + modelo + "%");
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }
}