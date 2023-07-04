package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="consejos")
public class Consejo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cons_id")
	private Long id;
	
	@Column(name="cons_categoria", nullable = false)
	@NotEmpty(message="Debe seleccionar una categoria")
	private String categoria;
	

	@Column(name="cons_link", nullable =false)
	@NotEmpty(message="No puede poner un link vacio")
	@Pattern(regexp = "^(http://|https://).*", message = "La URL debe empezar con http:// o https://")
	private String link;
	
	@Column(name="cons_desc", length=50, nullable =false)
	@NotEmpty(message="Necesita poner una descripción")
	@Size(max=50, message="El máximo permitido para una descripción son 50 caracteres")
	private String descripcion;

	@Column(name="cons_estado")
	private boolean estado;
	
	//Constructor sin parametros
	public Consejo() {
		
	}
	
	//Constructor parametrizado
	public Consejo(String categoria, String link, String descripcion, Long id) {
		this.categoria = categoria;
		//@NotNull
		this.link = link;
		//@NotNull
		this.descripcion = descripcion;
		}
	
	//Getters y setters
	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean getEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String ttoString() {
		return "{"+"descripcion: " + getDescripcion() + "link: " + getLink() + "categoria: " + getCategoria() + "id: " + getId() + "}"; 
	}
}
