package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaConsejoCategoria {
	private List<String> categorias;
	
	public ListaConsejoCategoria() {
		categorias= new ArrayList<String>();
		categorias.add("Gatos");
		categorias.add("Perros");
		categorias.add("General");
	}
	
	public List<String> getConsejoCategoria(){
		return categorias;
	}
	
	public void setConsejoCategoria(List<String> categorias) {
		this.categorias = categorias;
	}
}
