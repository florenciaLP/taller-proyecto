package ar.edu.unlam.tallerweb1.servicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Regalo;

@Service
public class ServicioEmailImpl implements ServicioEmail {

	private JavaMailSenderImpl mailSender;
	
	public ServicioEmailImpl() {
		this.mailSender = new JavaMailSenderImpl();
		new SimpleMailMessage();
	}

	@Override
	public void enviar(String to, String text) throws MessagingException {
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("tallerweb.onegift@gmail.com");
		mailSender.setPassword("tallerweb1unlam");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true);
		helper.setSubject("One gift - Regalo recibido");
		helper.setTo(to);
		helper.setText(text, true);
		mailSender.send(message);

	}

	public void enviarRegalo(Regalo regalo) throws IOException, MessagingException {
//		File template = new File("/Regalo/src/main/webapp/WEB-INF/vistas/mail.jsp");
//		String content = Files.readString(template.toPath());
		
		String content = "<h1>Ha recibido un regalo</h1>\n"
				+ "<h3><i>\"MENSAJE_REGALO\"</i></h3>\n"
				+ "<h3>Tu cupon es: NRO_CUPON</h3>\n"
				+ "<h3>Ya puede canjear su experiencia siguiendo este <a href=\"http://localhost:8080/Regalo/NRO_CUPON\">link</a></h3>";
		
		content = content.replace("NRO_CUPON", regalo.getCupon());
		content = content.replace("MENSAJE_REGALO", regalo.getMensaje());
		enviar(regalo.getEmailDestinatario(), content);
	}

}
