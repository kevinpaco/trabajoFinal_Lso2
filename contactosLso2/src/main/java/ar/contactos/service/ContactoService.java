package ar.contactos.service;

import java.util.List;

import ar.contactos.model.Contacto; 



public interface ContactoService {
	
	public Contacto guardarContacto(Contacto contacto);
	
	public List<Contacto> listarContacto(String palabraClabe);
	//public List<Contacto> listarContacto();
	
	public Contacto obtenerContacto(Long id);
	
	public Contacto actializarContacto(Contacto contacto);
	
	public void eliminarContacto(Long id);

}
