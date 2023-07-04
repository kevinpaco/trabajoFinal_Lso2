package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

@Component
public class ListaServicios {

	private List<Servicio> servicios;
		
		public ListaServicios() {
			servicios= new ArrayList<Servicio>();
		}
		
		public List<Servicio> getServicios() {
			return servicios;
		}
		
		public void setServicios(List<Servicio> servicios) {
			this.servicios = servicios;
		}

	}


