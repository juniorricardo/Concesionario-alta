package com.curso.spring.concesionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.spring.concesionaria.service.*;
import com.curso.spring.concesionaria.service.sql.ConectorDB;

/**
 * @author juniorricardo
 */
@Controller
public class HomeController {

    @Autowired
    ResgistroService miServicio;

    /**
     * 
     * @param modelo
     * @param model
     * @return
     */
    @GetMapping({ "/", "/lista-view"})
    public String procesar(@RequestParam(value = "txtBuscarModelo", 
    									 required = false, 
    									 defaultValue = "") String modelo, 
    									 Model model) {
//        model.addAttribute("listaVehiculos", miServicio.getListaVehiculos(modelo));
    	model.addAttribute("listaVehiculos", miServicio.getNuevoAutos());
        return "lista-view";
    }

    /**
     * 
     * @param modelo
     * @return
     */
    @GetMapping("/agregar-form")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("nuevoVehiculo", new Vehiculo());
        return "agregar-form";
    }

    /**
     * 
     * @param nuevo
     * @return
     */
    @PostMapping("/agregar-form")
    public String agregarVehiculo(@ModelAttribute Vehiculo nuevo) {
        miServicio.setVehiculo(nuevo);
        return "redirect:/agregar-form";
    }

}
