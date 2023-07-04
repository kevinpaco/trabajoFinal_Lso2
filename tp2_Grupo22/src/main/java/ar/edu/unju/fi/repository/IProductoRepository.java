package ar.edu.unju.fi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.entity.Servicio;

@Repository
public interface IProductoRepository extends CrudRepository<Producto,Long>{
	
	public List<Producto> findByEstado(boolean estado);
	
	@Query("SELECT p FROM Producto p WHERE p.categoria LIKE %?1% AND p.estado = true")
	public List<Producto>findByCategoria(String categoriaP);

}