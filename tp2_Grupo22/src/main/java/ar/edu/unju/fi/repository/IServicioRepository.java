package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Servicio;

@Repository
public interface IServicioRepository extends CrudRepository <Servicio, Long>{
	
	public List<Servicio>findByEstado(boolean estado);
	
	@Query("SELECT s FROM Servicio s WHERE s.dia LIKE %?1% AND s.estado = true")
	public List<Servicio>findByDia(String diaClave);
	
}
