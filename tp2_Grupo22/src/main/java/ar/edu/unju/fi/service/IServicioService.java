package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	//Obtiene la lista de todos los Servicios
	List<Servicio> getListaServicio(String diaClave);
	
	//Guarda un nuevo Servicio
	void guardarServicio(Servicio servicio);
	
	//Obtiene un Servicio por su identificador.
	Servicio getBy(Long id);
	
	//Modifica un Servicio existente.
	void modificarServicio(Servicio servicio);
	
	//Elimina un Servicio existente.
	void eliminarServicio(Servicio servicioEncontrado);
	
	//Obtiene un objeto Servicio.
	Servicio getServicio();
	
}
