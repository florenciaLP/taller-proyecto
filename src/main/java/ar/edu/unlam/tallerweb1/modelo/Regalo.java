package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;


@Entity
public class Regalo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario regalador;
	@NotNull
	private String emailDestinatario;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CajaDeRegalo cajaDeRegalo;
	@ManyToOne
	@JoinColumn(nullable = true)
	private Experiencia experiencia;
	@Column(columnDefinition = "boolean default false")
	private Boolean canjeado = false;
	@NotNull
	private String cupon;
	private String mensaje;
	private Date fechaRegistro;

	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCupon() {
		return cupon;
	}
	public void setCupon(String cupon) {
		this.cupon = cupon;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getRegalador() {
		return regalador;
	}
	public void setRegalador(Usuario regalador) {
		this.regalador = regalador;
	}
	public CajaDeRegalo getCajaDeRegalo() {
		return cajaDeRegalo;
	}
	public void setCajaDeRegalo(CajaDeRegalo cajaDeRegalo) {
		this.cajaDeRegalo = cajaDeRegalo;
	}
	public Experiencia getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	public Boolean getCanjeado() {
		return canjeado;
	}
	public void setCanjeado(Boolean canjeado) {
		this.canjeado = canjeado;
	}
	public String getEmailDestinatario() {
		return emailDestinatario;
	}
	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
