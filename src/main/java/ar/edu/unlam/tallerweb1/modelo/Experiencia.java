package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CajaDeRegalo cajaDeRegalo;
	@Column(columnDefinition = "boolean default false")
	private Boolean meGusta = false;
	
	
	
	public Boolean getMeGusta() {
		return meGusta;
	}
	public void setMeGusta(Boolean meGusta) {
		this.meGusta = meGusta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public CajaDeRegalo getCajaDeRegalo() {
		return cajaDeRegalo;
	}
	public void setCajaDeRegalo(CajaDeRegalo cajaDeRegalo) {
		this.cajaDeRegalo = cajaDeRegalo;
	}
	
	
}
