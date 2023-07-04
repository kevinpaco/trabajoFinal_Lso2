package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	@Qualifier("servicioServiceImp")
	private IServicioService servicioService;
	
	@Autowired
	private ICommonService commonService;
 

// Método para obtener la página de listado de servicios
@GetMapping("/listado")
public String getServiciosPage(Model model, @RequestParam(name = "diaClave", required = false) String diaClave) {
	model.addAttribute("servicios", servicioService.getListaServicio(diaClave));
	model.addAttribute("diaClave", diaClave);
	return "servicios";
}



//Método para obtener la página de creación de un nuevo servicio
@GetMapping("/nuevo")
public String getNuevoPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("servicio", servicioService.getServicio());
	model.addAttribute("categorias", commonService.getServicioCategoria());
	model.addAttribute("edicion",edicion);
	return "nuevo_servicio";
}



//Método para obtener la página de modificación de un servicio existente
@GetMapping("/modificar/{id}")
public String getModificarPage(Model model,@PathVariable(value="id")Long id){
	Servicio servicioEncontrado = servicioService.getBy(id);
	boolean edicion = true;
	model.addAttribute("servicio", servicioEncontrado);
	model.addAttribute("categorias", commonService.getServicioCategoria());
	model.addAttribute("edicion",edicion);	
	return "nuevo_servicio";	
}



//Método para procesar la modificación de un servicio
@PostMapping("/modificar")
public String modificarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result, Model model) {
	 if (result.hasErrors()) {
		 model.addAttribute("edicion", true);
		 model.addAttribute("categorias", commonService.getServicioCategoria());
		 return "nuevo_servicio";
	  }
	servicioService.modificarServicio(servicio);
	return "redirect:/servicios/listado";
}

	

// Método para guardar un nuevo servicio
@PostMapping("/guardar")
public ModelAndView getGuardarServiciosPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
	ModelAndView modelView = new ModelAndView("servicios");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_servicio");
		modelView.addObject("servicio", servicio);
		modelView.addObject("categorias", commonService.getServicioCategoria());
		return modelView;
	}
	servicioService.guardarServicio(servicio);
	String dia = "Lunes";
	modelView.addObject("servicios", servicioService.getListaServicio(dia));
	return modelView;
}



//Método para eliminar un servicio
@GetMapping("/eliminar/{id}")
public String eliminarServicio(@PathVariable(value="id") Long id) {
	Servicio servicioEncontrado = servicioService.getBy(id); 
	servicioService.eliminarServicio(servicioEncontrado);
	 return"redirect:/servicios/listado";
}

} 
