package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;

import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Implementación de la interfaz ISucursalService.
 * Maneja las operaciones de gestión de sucursales.
 */
@Service("SucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;
    @Autowired
    private Sucursal sucursal;
    
    /**
     * Obtiene una lista de todas las sucursales.
     *
     * @return la lista de sucursales
     */
    public List<Sucursal> getLista() {
        return sucursalRepository.findByEstado(true);
    }
    
    /**
     * Guarda una nueva sucursal.
     *
     * @param sucursal la sucursal a guardar
     */
    public void guardar(Sucursal sucursal) {
    	sucursal.setEstado(true);
    	sucursalRepository.save(sucursal);
    }
    
    /**
     * Obtiene una sucursal específica por su nombre.
     *
     * @param nombre el nombre de la sucursal
     * @return la sucursal con el nombre especificado
     */
    public Sucursal getBy(Long id) {
    	
        return sucursalRepository.findById(id).get();
    }
    
    /**
     * Modifica una sucursal existente.
     *
     * @param sucursal la sucursal actualizada
     */
    public void modificar(Sucursal sucursal) {
    	sucursal.setEstado(true);
    	sucursalRepository.save(sucursal);
    }
    
    /**
     * Elimina una sucursal.
     *
     * @param sucursal la sucursal a eliminar
     */
    public void eliminar(Sucursal sucursal) {
       sucursal.setEstado(false); 
       sucursalRepository.save(sucursal);
    }
    
    /**
     * Obtiene la sucursal actual.
     *
     * @return la sucursal actual
     */
    @Override
    public Sucursal getSucursal() {
        return sucursal;
    }
}