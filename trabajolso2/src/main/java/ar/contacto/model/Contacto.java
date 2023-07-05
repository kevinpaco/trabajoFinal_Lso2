package ar.contacto.model;

import java.time.LocalDate;  
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Component
@Entity
@Table(name= "Contactos")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOMBRE")
	@NotBlank(message = "Debe ingresar el Nombre")
	private String nombre;
	
	@Column(name="CELULAR")
	@NotNull(message = "Debe ingresar Num de celular")
	private Long celular;

	@Column(name="EMAIL")
	@NotEmpty(message = "Debe ingresar el Email")
	private String email;
	
	@Column(name="FECHA_NACIMIENTO")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe inresar una fecha de Nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name="FEHCA_REGISTRO")	
	private LocalDateTime fechaRegitro;
	
	public Contacto() {
		super();
	}
	public Contacto(String nombre, Long calular, String email, LocalDate fechaNacimiento, LocalDateTime fechaRegitro) {
		super();
		this.nombre = nombre;
		this.celular = calular;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegitro = fechaRegitro;
	}
	public Contacto(Long id, String nombre, Long calular, String email, LocalDate fechaNacimiento,
			LocalDateTime fechaRegitro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.celular = calular;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegitro = fechaRegitro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCelular() {
		return celular;
	}
	public void setCelular(Long calular) {
		this.celular = calular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDateTime getFechaRegitro() {
		return fechaRegitro;
	}
	public void setFechaRegitro(LocalDateTime fechaRegitro) {
		this.fechaRegitro = fechaRegitro;
	}
	
	//le va a asignar por defect la fecha de hoy o actual
	@PrePersist
	public void asignarFechaRegistro() {
		fechaRegitro = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", calular=" + celular + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaRegitro=" + fechaRegitro + "]";
	}
	
	
}
