package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;

@Component
public class ListaConsejos {
private List<Consejo> consejos;
	
	public ListaConsejos() {
		consejos = new ArrayList<Consejo>();
	
	}
	
	public List<Consejo> getConsejos() {
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

}
