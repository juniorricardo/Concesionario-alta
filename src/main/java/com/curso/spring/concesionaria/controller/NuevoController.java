package com.curso.spring.concesionaria.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/nuevo")
public class NuevoController {

    @GetMapping("/")
    public String procesar(@RequestParam(value = "txtBuscarModelo", required = false) String modelo, Model model) {

        if(modelo != null){
            
        }                           
        model.addAttribute("resultado", "nuevo mensaje");                                                                      
        //Consultar la base de datos para retornar la nueva lista
        //modelo.addAttribute("ofertas", miGestor.getOfertasDelMes(mes))
        return "";
    }



    
   /*  @GetMapping("")
    public String procesar2(HttpRequest peticion) {
        int mes = Integer.parseInt(peticion.getParameter("mes");
        return "algo";
    } */
}