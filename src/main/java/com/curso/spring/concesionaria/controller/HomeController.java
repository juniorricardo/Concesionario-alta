package com.curso.spring.concesionaria.controller;

import com.curso.spring.concesionaria.dominio.Auto;
import com.curso.spring.concesionaria.repository.IAutoRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author juniorricardo
 */
@Controller
public class HomeController {

//	@Autowired
//	ResgistroService miServicio;

	@Autowired
	IAutoRepo repo;

	@GetMapping({ "/", "lista-view"})
	public String listar(Model model) {
		model.addAttribute("listaAutos", repo.findAll());
		return "lista-view";
	}

	@GetMapping("/buscarModelo")
	public String procesar(@RequestParam(value = "buscarModelo", required = false, defaultValue = "") String buscar,
			Model model) {
		model.addAttribute("listaAutos", repo.findAllByMarcaLikeOrModeloLike("%" + buscar + "%", "%" + buscar + "%"));
		return "redirect:lista-view";
	}

	/**
	 * 
	 * @param modelo>
	 * @return Vista html agregar-form -> en ella podremos agregar un nuevo vehiculo
	 *         a la tabla
	 */
	@GetMapping("/agregar-form")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("nuevoVehiculo", new Auto());
		return "agregar-form";
	}

	/**
	 * 
	 * @param nuevoAuto
	 * @return recarga la pagina devolviendo el string, que hace referencia a la
	 *         vista agregar-form.html
	 */
	@PostMapping("/agregar-form")
	public String agregarVehiculo(Auto nuevoAuto) {
		repo.save(nuevoAuto);
		return "redirect:lista-view";
//		return "redirect:/agregar-form";
	}

}
