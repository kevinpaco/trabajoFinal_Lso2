package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.FormContacto;

@Controller
public class ContactosController {
	
	@GetMapping("/contactos")
	public String getContactosPage(Model model) {
		model.addAttribute("formContacto", new FormContacto());
		return "contactos";
	}
	
	
	@PostMapping("/contactos")
	public ModelAndView submitContactoForm(@ModelAttribute("formContacto") FormContacto formContacto) {
	    
		//Como no tengo la coneccion con la Base de datos, Imprimo los datos en la consola
	    System.out.println("Nombre: " + formContacto.getNombre());
	    System.out.println("Email: " + formContacto.getEmail());
	    System.out.println("Ciudad: " + formContacto.getCiudad());
	    System.out.println("Mensaje: " + formContacto.getMensaje());
		
		ModelAndView modelAndView = new ModelAndView("contactos");
	    modelAndView.addObject("mensaje", "¡Gracias por contactarnos!");    
	    return modelAndView;
	}
}
