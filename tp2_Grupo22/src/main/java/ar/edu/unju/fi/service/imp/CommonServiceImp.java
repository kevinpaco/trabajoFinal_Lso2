package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaConsejoCategoria;
import ar.edu.unju.fi.listas.ListaProductoCategoria;

import ar.edu.unju.fi.listas.ListaServicioCategoria;
import ar.edu.unju.fi.service.ICommonService;

/**
 * Implementación del servicio común (CommonServiceImp) que proporciona acceso a las listas de categorías.
 */
@Service
public class CommonServiceImp implements ICommonService {
    @Autowired
    ListaConsejoCategoria listaConsejoCategoria;

    /**
     * Obtiene la lista de categorías de consejo.
     *
     * @return la lista de categorías de consejo.
     */
    @Override
    public List<String> getConsejoCategoria() {
        return listaConsejoCategoria.getConsejoCategoria();
    }


    @Autowired
    ListaProductoCategoria listaProductoCategoria;
    
	@Override
	public List<String> getProductoCategoria() {
		return listaProductoCategoria.getProductoCategoria();
	}
	
	
	 /**
     * Obtiene la lista de categorías de servicios.
     *
     * @return la lista de categorías de servicios.
     */
	
	@Autowired
	ListaServicioCategoria listaServicioCategoria;
	
	@Override
	public List<String> getServicioCategoria(){
		return listaServicioCategoria.getServicioCategoria();
	}

	@Override
	public List<String> getProvinciaCategoria() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
