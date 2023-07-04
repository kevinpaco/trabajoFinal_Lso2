package ar.edu.unju.fi;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.repository.ISucursalRepository;

@SpringBootApplication
public class Tp2Grupo22Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Grupo22Application.class, args);
	}
	
	@Autowired
	IServicioRepository servicioRepository;
	
	@Autowired
	Servicio servicio;
	
	@Autowired
	Consejo consejo;
	
	@Autowired
	IConsejoRepository consejoRepository;
	
	@Autowired 
	Producto producto;
	
	@Autowired
	
	IProductoRepository productoRepository;
	
	@Autowired
	Sucursal sucursal;
	
	@Autowired
	
	ISucursalRepository sucursalRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Servicio servicio1 = new Servicio();
		servicio1.setEstado(true);
		servicio1.setPaseador("Mateo Garcia");
		servicio1.setDia("Lunes");
		servicio1.setHorainicio(9);
		servicio1.setHorafin(12);
		servicio1.setCategoria("Paseos");
		servicioRepository.save(servicio1);


		Servicio servicio2 = new Servicio();
		servicio2.setEstado(true);
		servicio2.setPaseador("Joaquin Burgos");
		servicio2.setDia("Martes");
		servicio2.setHorainicio(16);
		servicio2.setHorafin(20);
		servicio2.setCategoria("Peluqueria");
		servicioRepository.save(servicio2);
		
		
		Servicio servicio3 = new Servicio();
		servicio3.setEstado(true);
		servicio3.setPaseador("Araceli Lopez");
		servicio3.setDia("Miercoles"); //fijarse
		servicio3.setHorainicio(9);
		servicio3.setHorafin(12);
		servicio3.setCategoria("Entrenamiento");
		servicioRepository.save(servicio3);
		
		
		Servicio servicio4 = new Servicio();
		servicio4.setEstado(true);
		servicio4.setPaseador("Nicolas Cruz");
		servicio4.setDia("Viernes"); //fijarse
		servicio4.setHorainicio(16);
		servicio4.setHorafin(20);
		servicio4.setCategoria("Veternaria");
		servicioRepository.save(servicio4);		
		
		Consejo consejo1 = new Consejo();
		consejo1.setEstado(true);
		consejo1.setDescripcion("Comida apta para gatos");
		consejo1.setLink("https://www.google.com");
		consejo1.setCategoria("Gatos");
		consejoRepository.save(consejo1);
		Consejo consejo2 = new Consejo();
		consejo2.setEstado(true);
		consejo2.setDescripcion("Comida apta para perros");
		consejo2.setLink("https://www.google.com");
		consejo2.setCategoria("Perros");
		consejoRepository.save(consejo2);
		Consejo consejo3 = new Consejo();
		consejo3.setEstado(true);
		consejo3.setDescripcion("Comida apta para todos los animales");
		consejo3.setLink("https://www.google.com");
		consejo3.setCategoria("General");
		consejoRepository.save(consejo3);
		
		 Producto producto1 = new Producto();
		 producto1.setNombre("Estante para perro");
		 producto1.setPrecio(454);
		 producto1.setCategoria("Mueble");
		 producto1.setDescuento(33);
		 producto1.setEstado(true);
		 productoRepository.save(producto1);
		 
		 Producto producto2 = new Producto();
		 producto2.setNombre("Hueso masticable");
		 producto2.setPrecio(4000);
		 producto2.setCategoria("Juguete");
		 producto2.setDescuento(40);
		 producto2.setEstado(true);
		 productoRepository.save(producto2);
		 
		 Sucursal sucursal1 = new Sucursal();
		 sucursal1.setNombre("DonCacho Petshop");
		 sucursal1.setDireccion("Av. Siempreviva 742");
		 sucursal1.setEmail("doncacho@petshop.com");
		 sucursal1.setProvincia("Jujuy");
		 sucursal1.setTelefono("3885939495");
		 sucursal1.setEmpleados(5);
		 sucursal1.setFechaInicio(LocalDate.of(2023, 6, 25));
		 sucursal1.setEstado(true);
		 sucursalRepository.save(sucursal1);
		 
	}	

	
}
