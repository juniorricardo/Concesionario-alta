package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.dominio.Auto;
import com.curso.spring.concesionaria.repository.IAutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author juniorricardo
 */
@Controller
@RequestMapping("/concesionaria")
public class HomeController {

    @Autowired
    IAutoRepo repo;

    @GetMapping({"/", "lista-view"})
    public String listar(Model model) {
        model.addAttribute("listaAutos", repo.findAll());
        return "lista-view";
    }

    //  localhost:8080/concesionaria/buscarModelo?buscarModelo=e
    @GetMapping("/buscarModelo")
    public ResponseEntity<Auto> buscarFiltro(@RequestParam(value = "buscarModelo", required = false, defaultValue = "") String buscar,
                                             Model model) {
        List<Auto> resultado = repo.findAllByMarcaLikeOrModeloLike("%" + buscar + "%", "%" + buscar + "%");
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    /**
     * @param modelo>
     * @return Vista html agregar-form -> en ella podremos agregar un nuevo vehiculo
     * a la tabla
     */
    @GetMapping("/agregar-form")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("nuevoVehiculo", new Auto());
        return "/agregar-form";
    }

    /**
     * @param nuevoAuto
     * @return recarga la pagina devolviendo el string, que hace referencia a la
     * vista agregar-form.html
     */
    @PostMapping("/agregar-form")
    public String agregarVehiculo(Auto nuevoAuto) {
        repo.save(nuevoAuto);
        return "redirect:lista-view";
//		return "redirect:/agregar-form";
    }

}
