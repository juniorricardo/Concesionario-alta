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
		model.addAttribute("listaAutos", repo.findAll());
		return "lista-view";
	}

	@GetMapping("/buscarModelo")
	public String procesar(@RequestParam(value = "buscarModelo", required = false, defaultValue = "") String modelo,
						   Model model) {
		if(repo.findByModelo(modelo) == null){
			model.addAttribute("listaAutos", repo.findAll());
			model.addAttribute("estado", "No se encontro el modelo.");
		}else{
			model.addAttribute("listaAutos", repo.findByModelo(modelo));
		}
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
	 * @param nuevoVehiculo
	 * @return recarga la pagina devolviendo el string, que hace referencia a la
	 *         vista agregar-form.html
	 */
	@PostMapping("/agregar-form")
	public String agregarVehiculo(@ModelAttribute Autos nuevoVehiculo) {
		repo.save(nuevoVehiculo);
		return "redirect:/agregar-form";
	}

}
