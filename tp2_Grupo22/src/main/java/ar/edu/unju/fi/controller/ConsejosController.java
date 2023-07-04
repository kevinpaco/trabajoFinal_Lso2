package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos")
public class ConsejosController {
	@Autowired
	@Qualifier("consejoServiceImp")
	private IConsejoService consejoService;
	
	@Autowired
	private ICommonService commonService;
	
	
	//Pagina con el listado de los consejos (Cada uno está separado por categoría con th:if)
@GetMapping("/listado")
public String getConsejosPage(Model model) {
	model.addAttribute("consejos", consejoService.getConsejos());
	return "consejos";
}


	//Pagina para crear un consejo nuevo
@GetMapping("/nuevo")
public String getNuevoConsejoPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("consejo", consejoService.getConsejo());
	model.addAttribute("categorias", commonService.getConsejoCategoria());
	model.addAttribute("edicion",edicion);
	return "nuevo_consejo";
}

@GetMapping("/modificar/{id}")
public String getModificarConsejosPage(Model model,@PathVariable(value="id")Long id){
	boolean edicion = true;
	Consejo consejoEncontrado = consejoService.getBy(id);
	model.addAttribute("consejo", consejoEncontrado);
	model.addAttribute("categorias", commonService.getConsejoCategoria());
	model.addAttribute("edicion",edicion);
	
	return "nuevo_consejo";	
}

@PostMapping("/modificar")
public ModelAndView getModificarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
	ModelAndView modelView = new ModelAndView("consejos");
	boolean edicion = true;
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_consejo");
		modelView.addObject("consejo", consejo);
		modelView.addObject("categorias", commonService.getConsejoCategoria());
		modelView.addObject("edicion", edicion);
		return modelView;
	}
	consejoService.guardar(consejo);
	modelView.addObject("consejos", consejoService.getConsejos());
	return modelView;
}

	//Pagina de guardado de los consejos
@PostMapping("/guardar")
public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
	ModelAndView modelView = new ModelAndView("consejos");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_consejo");
		modelView.addObject("consejo", consejo);
		modelView.addObject("categorias", commonService.getConsejoCategoria());
		return modelView;
	}
	consejoService.guardar(consejo);
	modelView.addObject("consejos", consejoService.getConsejos());
	return modelView;
}

	//Pagina para eliminar consejos
@GetMapping("/eliminar/{id}")
public String eliminarConsejo(@PathVariable(value="id") Long id) {
			Consejo consejoEncontrado = consejoService.getBy(id);
			consejoService.eliminar(consejoEncontrado);

	
	 return"redirect:/consejos/listado";
}

}
