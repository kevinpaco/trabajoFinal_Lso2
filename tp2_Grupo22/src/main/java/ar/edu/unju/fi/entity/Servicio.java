package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="servicios")
public class Servicio {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serv_id")
	private Long id;
	
	@NotBlank(message="Debe elegir un día")
	@Column(name="serv_dia", nullable = false)
	private String dia;
	
	@NotEmpty(message="El nombre del paseador no puede permanecer vacío")
	@Size(min=5, max=40, message="El nombre del paseador debe contener entre 5 y 40 caracteres")
	@Column(name="serv_paseador", length = 40, nullable = false)
	private String paseador;
	
	@NotNull(message = "La hora de inicio no puede estar vacía")
	@Min(value=9, message="La hora mínima para empezar un horario de un paseador son a las 9")
	@Max(value=22, message="La hora mínima para empezar un horario de un paseador son a las 9")
	@Column(name="serv_hora_inicio", nullable = false)
	private Integer horainicio;
	
	@NotNull(message = "La hora de fin no puede estar vacía")
	@Min(value=10, message="La hora mínima para terminar un horario de un paseador son a las 10")
	@Max(value=24, message="La hora máxima para terminar un horario de un paseador son a las 24")
	@Column(name="serv_hora_final", nullable = false)
	private Integer horafin;
	
	@NotBlank(message="Debe elegir un tipo de servicio")
	@Column(name="serv_categoria", nullable = false)
	private String categoria;
	
	@Column(name="serv_estado")
	private boolean estado;
	
	
	//Constructor sin parametros
	public Servicio() {
		
	}
	
	//Constructor parametrizado
	public Servicio(Long id, String dia,String paseador,Integer horainicio, Integer horafin, String categoria) {
		this.dia = dia;
		this.paseador = paseador;
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.categoria = categoria;
	}

	//Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}
	
	
	public String getPaseador() {
		return paseador;
	}



	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}
	
	public Integer getHorainicio() {
		return horainicio;
	}



	public void setHorainicio(Integer horainicio) {
		this.horainicio = horainicio;
	}
	

	
	public Integer getHorafin() {
		return horafin;
	}



	public void setHorafin(Integer horafin) {
		this.horafin = horafin;
	}

	
	
	public String getCategoria() {
		return categoria;
	}

	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String toString() {
		return "Servicio [id=" + id + ", dia=" + dia + ", paseador=" + paseador + ", horainicio=" + horainicio
				+ ", horafin=" + horafin + ", categoria=" + categoria + "]";
	}

}
