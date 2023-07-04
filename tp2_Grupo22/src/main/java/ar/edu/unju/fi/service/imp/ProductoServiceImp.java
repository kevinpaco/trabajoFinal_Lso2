package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service("productoServiceMysql")
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private Producto producto;

	@Override
	public List<Producto> getListaP(String categoriaP) {
		if(categoriaP != null) {
			return productoRepository.findByCategoria(categoriaP);
		}
		return productoRepository.findByEstado(true);
	}

	@Override
	public void guardarProducto(Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);
		// TODO Auto-generated method stub

	}

	@Override
	public Producto getBy(Long id){
		return productoRepository.findById(id).get();
	}



	@Override
	public void eliminarProducto(Producto productoEncontrado) {
		productoEncontrado.setEstado(false);
		productoRepository.save(productoEncontrado);
	}

	@Override
	public Producto getProducto() {

		return producto;
	}

}