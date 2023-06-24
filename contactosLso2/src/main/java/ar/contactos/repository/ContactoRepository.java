package ar.contactos.repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.contactos.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{

	@Query("SELECT p FROM Contacto p WHERE" + " CONCAT(p.nombre,p.email)" + " LIKE %?1%")
	public List<Contacto> listarContacto(String palabraCable);
	
	/*@Query("from Contacto e order by e.nombre")
	public List<Contacto> listarContacto();*/
}
