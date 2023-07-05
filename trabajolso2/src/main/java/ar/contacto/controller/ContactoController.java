package ar.contacto.controller;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.contacto.model.Contacto;
import ar.contacto.service.ContactoService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	@Autowired
	private ContactoService contactoService; 
	
	@GetMapping("/nuevo")
	public String nuevoContacto(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "nuevo-contacto";
	}
	
	//este metodo es e guardar pero va con nuevo por el return de las validasiones
	@PostMapping("/nuevo")
	public String guardarContacto(@Validated @ModelAttribute("contacto")Contacto contacto,BindingResult bindingResult, Model model ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("contacto", contacto);
			return "nuevo-contacto";
		}
		else {
		contactoService.guardarContacto(contacto);
		
		return"redirect:/contacto/agenda";}
	}
	
	@GetMapping("/agenda")
	public String agenda(Model model, @Param("palabraClave")String palabraClave) {
		List<Contacto> listaContacto = contactoService.listarContacto(palabraClave);
		model.addAttribute("datosAgenda", listaContacto );
		model.addAttribute("palabraClave", palabraClave);
		return "agenda";
	}
	
	@GetMapping("/editar/{id}")
	public String editarContacto(@PathVariable Long id,Model model) {
		Contacto contacto= contactoService.obtenerContacto(id);
		model.addAttribute("contacto", contacto);
		return"editar-contacto";
	}
	
	@PostMapping("/actualizar/{id}")
	public String actualizarContacto(@PathVariable Long id,@Validated @ModelAttribute("contacto")Contacto contacto,BindingResult bindingResult, Model model ) {
		Contacto contactoBD = contactoService.obtenerContacto(id);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("contacto", contacto);
			return "editar-contacto";
		}
		else {
			
	    contactoBD.setNombre(contacto.getNombre());
	    contactoBD.setCelular(contacto.getCelular());
	    contactoBD.setEmail(contacto.getEmail());
	    contactoBD.setFechaNacimiento(contacto.getFechaNacimiento());
	    contactoBD.setFechaRegitro(contacto.getFechaRegitro());
		contactoService.guardarContacto(contactoBD);
		
		return"redirect:/contacto/agenda";}
	}
	
	@PostMapping("/eliminar/{id}")
	public String eliminarContacto(@PathVariable Long id,Model model) {
		
		contactoService.eliminarContacto(id);
		
		return"redirect:/contacto/agenda";
		}
}
