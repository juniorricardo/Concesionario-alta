package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.domain.Bicicleta;
import com.curso.spring.concesionaria.repository.IBicicletaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {

    @Autowired
    IBicicletaRepo repo;

    //  http://localhost:8080/bicicletas/lista
    @GetMapping("/lista")
    public ResponseEntity<Bicicleta> getAllBicicleta(Model modelo){
        List<Bicicleta> bicicletas = repo.findAll();
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }

    //  http://localhost:8080/bicicletas/buscar?marca=Venzo
    //  http://localhost:8080/bicicletas/buscar?marca=Trek
    @GetMapping("/buscar")
    public ResponseEntity<Bicicleta> mostrarMarca(@RequestParam String marca){
        List<Bicicleta> bicicletas = repo.findByMarcaLike("%" + marca + "%");
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }

    //  http://localhost:8080/bicicletas/buscarPath/Trek
    @GetMapping("/buscarPath/{marca}")
    public ResponseEntity<Bicicleta> mostrarMarca2(@PathVariable String marca){
        List<Bicicleta> bicicletas = repo.findByMarcaLike("%" + marca + "%");
        return new ResponseEntity(bicicletas, HttpStatus.OK);
    }

    //  http://localhost:8080/bicicletas/findModelo?marca=Trek&modelo=Pro
    @GetMapping("/findModelo")
    public Bicicleta mostrarMarcaModelo(@RequestParam String marca,
                                        @RequestParam String modelo){
        return repo.findByMarcaAndModeloLike(marca, "%" + modelo + "%");
    }

    //  http://localhost:8080/bicicletas/addBici
    @PostMapping("/addBici")
    public Bicicleta agregarBicicleta(@RequestBody Bicicleta body){
        return repo.save(body);
    }

    //  http://localhost:8080/bicicletas/dropBici?id=6
    @DeleteMapping("/dropBici")
    public Bicicleta eliminarBicleta(@RequestParam long id){
        Optional<Bicicleta> al = repo.findById(id);
        if (al.isPresent()) {
            repo.delete(al.get());
            return al.get();
        } else return null;
    }
}