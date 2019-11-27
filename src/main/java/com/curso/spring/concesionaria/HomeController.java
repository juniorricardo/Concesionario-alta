package com.curso.spring.concesionaria;

import com.curso.spring.concesionaria.dominio.Autos;
import com.curso.spring.concesionaria.repository.AutosRepo;
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
	AutosRepo repo;

	@GetMapping("/")
	public String listar(Model model) {
		//model.addAttribute("listaVehiculos", miServicio.getListVehiculos(modelo));
		model.addAttribute("listaAutos", repo.findAll());
		return "lista-view";
	}

	@GetMapping("/lista-view/{marca}/{modelo}")
	public String procesar(@PathVariable String marca,
						   @PathVariable String modelo,
						   Model model) {
		model.addAttribute("listaAutos", repo.findAllByModeloLikeOrMarcaLike(marca,modelo));
		return "lista-view";
	}

	/**
	 * 
	 * @param modelo
	 * @return Vista html agregar-form -> en ella podremos agregar un nuevo vehiculo
	 *         a la tabla
	 */
	@GetMapping("/agregar-form")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("nuevoVehiculo", new Autos());
		return "agregar-form";
	}

	/**
	 * 
	 * @param nuevo
	 * @return recarga la pagina devolviendo el string, que hace referencia a la
	 *         vista agregar-form.html
	 */
//	@PostMapping("/agregar-form")
//	public String agregarVehiculo(@ModelAttribute Auto nuevo, String nuevo) {
//		miServicio.setVehiculo(nuevo);
//		return "redirect:/agregar-form";
//	}

}
