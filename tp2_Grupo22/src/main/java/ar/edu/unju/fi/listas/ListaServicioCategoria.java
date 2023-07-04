package ar.edu.unju.fi.listas;

import java.util.List;
import java.util.ArrayList;


import org.springframework.stereotype.Component;

@Component
public class ListaServicioCategoria {
	
	private List<String> categorias;
	
	public ListaServicioCategoria() {
		categorias= new ArrayList<String>();
		categorias.add("Paseos");
		categorias.add("Peluqueria");
		categorias.add("Entrenamiento");
		categorias.add("Veternaria");
		
	}
	
	public List<String> getServicioCategoria(){
		return categorias;
	}
	
	public void setServicioCategoria(List<String> categorias) {
		this.categorias = categorias;
	}
}
