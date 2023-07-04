package ar.edu.unju.fi.entity;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table (name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "El nombre es obligatorio.")
	@Size(min=2, max=50 , message = "El nombre debe contener entre 5 y 50 caracteres.")
	@Column(name="prod_nombre" ,length = 50)
	private String nombre;
	
	@NotNull(message="El precio no puede estar vacío.")
	@DecimalMin(value = "3.0", message = "El precio debe ser mayor a 3 pesos.")
    @DecimalMax(value = "900000.0", message = "El precio debe ser menor o igual a 900000 pesos.")
	@Column(name="prod_precio" ,nullable = false,length = 50)
	private float precio;
	
	@NotNull(message = "Seleccione una categoria.")
	@Column(name="prod_categoria" ,nullable = false)
	private String categoria;
	
	@NotNull(message = "El numero de descuento no puede estar vacío.")
	@Max(value = 50, message = "El descuento debe ser menor o igual a 50.")
	@Column(name="prod_descuento" ,nullable = false)
	private int descuento;
	
	@Column(name="prod_estado")
	private boolean estado;
	
	
	//Constructor sin parametros
	public Producto() {
		
	}
	
	//Contructor parametrizado
	public Producto(Long id, String nombre, float precio, String categoria, int descuento) {
        super();
		this.id = id;
		this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
    }

	public Producto(String nombre, float precio, String categoria, int descuento) {
        super();
		this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
    }

	
	//Getters and Setters
	
	
	public String getNombre() {
		return nombre;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public int getDescuento() {
		return descuento;
	}



	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	 
	
	//Metodo para el descuento
	public double calcularDescuento() {
		double descuentoCalculado = 0.0;
		if (descuento > 0 && descuento <= 50) {
				descuentoCalculado = precio * (descuento / 100.0);
		   }
		   return precio - descuentoCalculado;
	}	
	
}
