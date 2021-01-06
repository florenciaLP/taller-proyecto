package ar.edu.unlam.tallerweb1.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CajaDeRegalo")
public class CajaDeRegalo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroDeCaja;
	private String nombre;
	private String descripcion;
	private Integer precio;
	private Integer cantidadPersonas;
	private String imagen;
	@Transient
	private Set<Experiencia> experiencias;

	public Integer getNumeroDeCaja() {
		return numeroDeCaja;
	}

	public void setNumeroDeCaja(Integer numeroDeCaja) {
		this.numeroDeCaja = numeroDeCaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
