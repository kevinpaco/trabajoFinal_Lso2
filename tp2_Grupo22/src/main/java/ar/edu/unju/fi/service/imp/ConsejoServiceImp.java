package ar.edu.unju.fi.service.imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;


@Service("consejoServiceImp")
public class ConsejoServiceImp implements IConsejoService {
@Autowired
private Consejo consejo;
@Autowired 
private IConsejoRepository consejoRepository;

//Devuelve el listado completo de consejos
@Override
public List<Consejo> getConsejos() {
	return consejoRepository.findByEstado(true);
}

//Guarda un nuevo consejo en el listado de consejos
@Override
public void guardar(Consejo consejo) {
	consejo.setEstado(true);
	System.out.print(consejo.ttoString());
	consejoRepository.save(consejo);
}

//Obtiene un consejo existente a partir de su descripción
@Override
public Consejo getBy(Long id) {
	return consejoRepository.findById(id).get();
}

//Elimina un consejo especificado
@Override
public void eliminar(Consejo consejoEncontrado) {
	//Eliminación lógica (cambiando el valor de la variable estado a false), no se borra completamente de la tabla
	consejoEncontrado.setEstado(false);
	consejoRepository.save(consejoEncontrado);

}

//Devuelve un consejo nuevo
@Override
public Consejo getConsejo() {
	return consejo;
}


}
