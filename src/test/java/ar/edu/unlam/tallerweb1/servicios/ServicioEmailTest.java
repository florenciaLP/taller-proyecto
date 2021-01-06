package ar.edu.unlam.tallerweb1.servicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.mail.MessagingException;

import org.junit.Test;

public class ServicioEmailTest {
	
	@Test
	public void enviarMailTest() throws MessagingException {
		ServicioEmailImpl mail = new ServicioEmailImpl();
		
		File template = new File("src/main/webapp/WEB-INF/vistas/mail.jsp");
		String actual = "";
		try {
			actual = Files.readString(template.toPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		actual = actual.replace("NRO_CUPON", "AGFBFH5436");
		mail.enviar("heittcristianagustin@gmail.com", actual);
	}
}
