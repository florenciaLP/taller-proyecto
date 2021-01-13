package ar.edu.unlam.tallerweb1.servicios;

import java.io.IOException;

import javax.mail.MessagingException;

import ar.edu.unlam.tallerweb1.modelo.Regalo;

public interface ServicioEmail {
	public void enviar(String to, String text) throws MessagingException;
	public void enviarRegalo(Regalo regalo) throws IOException, MessagingException;
}
