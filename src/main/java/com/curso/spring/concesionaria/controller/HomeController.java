package com.curso.spring.concesionaria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.spring.concesionaria.service.*;

@Controller
public class HomeController {

    @Autowired
    ResgistroService miServicio;

    // @GetMapping({ "/", "/lista-view" })
    // public String mostrarLista(@ModelAttribute ArrayList<Vehiculo> listaModelos, Model modelo) {
    //     modelo.addAttribute("listaVehiculos", miServicio.getListaVehiculos());
    //     modelo.addAttribute("objBuscar", new Vehiculo());
    //     return "lista-view";
    // }

    /**
     * 
     * @param modelo
     * @param model
     * @return
     */
    @GetMapping({ "/", "/lista-view"})
    public String procesar(@RequestParam(value = "txtBuscarModelo", required = false) String modelo, Model model) {

        if (modelo != null) {
            ArrayList<Vehiculo> resultado = miServicio.getListaModelo(modelo);
            model.addAttribute("listaVehiculos", resultado);
        }
        else{
            model.addAttribute("listaVehiculos", miServicio.getListaVehiculos());
        }
        model.addAttribute("objBuscar", new Vehiculo());
        return "lista-view";
    }


    

    @GetMapping("/agregar-form")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("nuevoVehiculo", new Vehiculo());
        return "agregar-form";
    }

    @PostMapping("/agregar-form")
    public String agregarVehiculo(@ModelAttribute Vehiculo nuevo) {
        miServicio.setVehiculo(nuevo);
        return "redirect:/agregar-form";
    }

    @GetMapping("/busqueda-form")
    public String resultadoBusqueda(Model modelo) {
        modelo.addAttribute("objBuscar", new Vehiculo());
        modelo.addAttribute("tablaModelos", new ArrayList<Vehiculo>());
        return "busqueda-form";
    }

    @PostMapping("/buscar-modelo")
    public String getModelo(@ModelAttribute Vehiculo objBuscar, Model modelo) {

        ArrayList<Vehiculo> resultado = miServicio.getListaModelo(objBuscar.getModelo());

        if (resultado == null) {
            return "resultado-view";
        } else {
            modelo.addAttribute("mensaje", "ok");
            modelo.addAttribute("tablaModelos", resultado);
        }
        modelo.addAttribute("objBuscar", new Vehiculo());
        return "busqueda-form";
    }

}
