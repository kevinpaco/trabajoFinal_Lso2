package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "tableSucu")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suc_id")
    private Long id;
    @Column(name = "suc_nombre", length = 30, nullable = false)
    @Size(max=30, message="El nombre puede contener solo hasta 30 caracteres.")
    @NotEmpty(message="El nombre no puede estar vacío.")
    private String nombre;
    @Column(name = "suc_direccion",length=50, nullable = false)
    @Size(max=50, message="La direccion puede contener solo hasta 50 caracteres.")
    @NotEmpty(message="La direccion no puede estar vacía.")
    private String direccion;
    @Column(name = "suc_provincia", nullable = false)
    @NotEmpty(message="Seleccione una provincia.")
    private String provincia;
    @Column(name = "suc_fechainicio", nullable = false)
    @NotNull(message="Seleccione una fecha.")
    private LocalDate fechaInicio;
    @Column(name = "suc_email", nullable = false)
    @NotEmpty(message="El email no puede quedar vacío.")
    private String email;
    @Column(name = "suc_telefono", nullable = false)
    @Min(value=100000000, message="El numero de telefono debe tener 9 digitos.")
    private String telefono;
    @Column(name = "suc_empleados", nullable = false)
    @Min(value=2, message="Deben haber al menos 2 empleados por sucursal.")
    private int empleados;
    @Column(name = "suc_estado")
    private boolean estado;

    /**
     * Constructor de la clase Sucursal.
     *
     * @param id          el ID de la sucursal.
     * @param nombre      el nombre de la sucursal.
     * @param direccion   la dirección de la sucursal.
     * @param provincia   la provincia de la sucursal.
     * @param fechaInicio la fecha de inicio de la sucursal.
     * @param email       el correo electrónico de la sucursal.
     * @param telefono    el número de teléfono de la sucursal.
     * @param empleados   el número de empleados de la sucursal.
     * @param estado      el estado de borrado logico en la base de datos.
     */
   public Sucursal() {
	   
   }
    
    public Sucursal(Long id, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
            String telefono, int empleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.provincia = provincia;
        this.fechaInicio = fechaInicio;
        this.email = email;
        this.telefono = telefono;
        this.empleados = empleados;
    }

    // Getters y setters

    /**
     * Obtiene el ID de la sucursal.
     *
     * @return el ID de la sucursal.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la sucursal.
     *
     * @param id el ID de la sucursal a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la sucursal.
     *
     * @return el nombre de la sucursal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la sucursal.
     *
     * @param nombre el nombre de la sucursal a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección de la sucursal.
     *
     * @return la dirección de la sucursal.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la sucursal.
     *
     * @param direccion la dirección de la sucursal a establecer.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la provincia de la sucursal.
     *
     * @return la provincia de la sucursal.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia de la sucursal.
     *
     * @param provincia la provincia de la sucursal a establecer.
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Obtiene la fecha de inicio de la sucursal.
     *
     * @return la fecha de inicio de la sucursal.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la sucursal.
     *
     * @param fechaInicio la fecha de inicio de la sucursal a establecer.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene el correo electrónico de la sucursal.
     *
     * @return el correo electrónico de la sucursal.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico de la sucursal.
     *
     * @param email el correo electrónico de la sucursal a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono de la sucursal.
     *
     * @return el número de teléfono de la sucursal.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la sucursal.
     *
     * @param telefono el número de teléfono de la sucursal a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el número de empleados de la sucursal.
     *
     * @return el número de empleados de la sucursal.
     */
    public int getEmpleados() {
        return empleados;
    }

    /**
     * Establece el número de empleados de la sucursal.
     *
     * @param empleados el número de empleados de la sucursal a establecer.
     */
    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    /**
     * Verifica el estado de la sucursal.
     *
     * @return true si la sucursal está activa, false si está inactiva.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la sucursal.
     *
     * @param estado el estado de la sucursal a establecer.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
