package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceImp")
public class ServicioServiceImp implements IServicioService {
	
	@Autowired
	private Servicio servicio;
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	
	//Devuelve la lista de servicios
	@Override
	public List<Servicio> getListaServicio(String diaClave){
		if(diaClave != null) {
			return servicioRepository.findByDia(diaClave);
		}
		return servicioRepository.findByEstado(true);
	}
	
	
	//Guarda un servicio
	@Override
	public void guardarServicio(Servicio servicio) {
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	
	//Busca un servicio segun el nombre del paseador
	@Override
	public Servicio getBy(Long id) {
		return servicioRepository.findById(id).get();
	}
	
	
	
	//Modifica un servicio 
	@Override
	public void modificarServicio(Servicio servicio) {
	        servicio.setEstado(true);
	        servicioRepository.save(servicio);
	}
	
	
	
	//Elimina un servicio
	@Override
	public void eliminarServicio(Servicio servicioEncontrado) {
		servicioEncontrado.setEstado(false);
		servicioRepository.save(servicioEncontrado);
	}
	
	
	//Devuelve un servicio
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	
	
}
