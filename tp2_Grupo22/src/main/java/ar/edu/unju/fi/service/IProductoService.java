package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;
import jakarta.validation.Valid;

public interface IProductoService {
	
	// Listar productos
    List<Producto> getListaP(String categoriaP);

    // Guardar productos
    void guardarProducto(Producto producto);

    // Obtener producto por código
    public Producto getBy(Long id);

    // Eliminar un producto
    void eliminarProducto(Producto productoEncontrado);

    // Obtener producto nuevo
    Producto getProducto();


}