package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaProductoCategoria {
	private List<String> categorias;
	
	public ListaProductoCategoria() {
		categorias= new ArrayList<String>();
		categorias.add("Juguete");
		categorias.add("Mueble");
		categorias.add("Mascota");
		categorias.add("Comida");
	}
	
	public List<String> getProductoCategoria(){
		return categorias;
	}
	
	public void setProductoCategoria(List<String> categorias) {
		this.categorias = categorias;
	}
}


