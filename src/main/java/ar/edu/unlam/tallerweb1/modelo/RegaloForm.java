package ar.edu.unlam.tallerweb1.modelo;

public class RegaloForm {
	private String email;
	private long idRegalador;
	private Integer numeroCajaDeRegalo;
	private String mensaje;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getIdRegalador() {
		return idRegalador;
	}
	public void setIdRegalador(long idBeneficiario) {
		this.idRegalador = idBeneficiario;
	}
	public Integer getNumeroCajaDeRegalo() {
		return numeroCajaDeRegalo;
	}
	public void setNumeroCajaDeRegalo(Integer numeroCajaDeRegalo) {
		this.numeroCajaDeRegalo = numeroCajaDeRegalo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
