package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import ar.edu.unju.fi.entity.*;
import ar.edu.unju.fi.listas.*;
import jakarta.validation.Valid;


public interface IConsejoService {


	//Listado de Consejos
	List<Consejo> getConsejos();
	//Guardado de consejos
	void guardar(Consejo consejo);
	//Obtener un consejo segun su descripcion
	Consejo getBy(Long id);
	//Eliminar un consejo
	void eliminar(Consejo consejoEncontrado);
	//Generar un nuevo consejo
	Consejo getConsejo();
}
