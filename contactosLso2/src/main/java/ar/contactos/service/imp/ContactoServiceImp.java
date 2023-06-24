package ar.contactos.service.imp;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.contactos.model.Contacto;
import ar.contactos.repository.ContactoRepository;
import ar.contactos.service.ContactoService;


@Service
public class ContactoServiceImp implements ContactoService {

	@Autowired
	ContactoRepository contactoRepository;
	
	@Override
	public Contacto guardarContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepository.save(contacto);
	}
	
	@Override
	public List<Contacto> listarContacto(String palabraClave) {
		// TODO Auto-generated method stub
		if(palabraClave != null) {
			//este listar es de el CRUD
			return contactoRepository.listarContacto(palabraClave);
		}
		return contactoRepository.findAll();
	}

	/*@Override
	public List<Contacto> listarContacto() {
		// TODO Auto-generated method stub
		return contactoRepository.findAll();
	}*/

	@Override
	public Contacto obtenerContacto(Long id) {
		// TODO Auto-generated method stub
		return contactoRepository.findById(id).get();
	}

	@Override
	public Contacto actializarContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepository.save(contacto);
	}

	@Override
	public void eliminarContacto(Long id) {
		// TODO Auto-generated method stub
		
		contactoRepository.deleteById(id);
	}

}
