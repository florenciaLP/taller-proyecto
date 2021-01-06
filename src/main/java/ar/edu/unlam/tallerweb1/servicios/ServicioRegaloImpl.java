package ar.edu.unlam.tallerweb1.servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioExperiencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegalo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import utils.RandomCuponCode;

@Service
@Transactional
public class ServicioRegaloImpl implements ServicioRegalo {

	private RepositorioRegalo servicioRegaloDAO;
	private RepositorioUsuario servicioUsuarioDAO;
	private RepositorioExperiencia servicioExperienciaDAO;
	private ServicioEmail servicioEmail;
	
	@Autowired
	public ServicioRegaloImpl(RepositorioRegalo servicioRegaloDAO, RepositorioUsuario servicioUsuarioDAO,
			RepositorioExperiencia servicioExperienciaDAO) {
		this.servicioRegaloDAO = servicioRegaloDAO;
		this.servicioUsuarioDAO = servicioUsuarioDAO;
		this.servicioExperienciaDAO = servicioExperienciaDAO;
		servicioEmail = new ServicioEmailImpl();
	}

	@Override
	public Boolean guardarRegalo(RegaloForm regaloForm) throws IOException {
		Regalo regalo = new Regalo();
		CajaDeRegalo caja = new CajaDeRegalo();
		caja.setNumeroDeCaja(regaloForm.getNumeroCajaDeRegalo());
		regalo.setEmailDestinatario(regaloForm.getEmail());
		regalo.setCajaDeRegalo(caja);
		regalo.setRegalador(servicioUsuarioDAO.getUserById(regaloForm.getIdRegalador()));
		regalo.setCupon(RandomCuponCode.getRandomCode());
		regalo.setMensaje(regaloForm.getMensaje());
		
		try {
			System.out.println("ENVIANDO EL MAIL");
			servicioEmail.enviarRegalo(regalo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("PINCHO 1");
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("PINCHO 2");
		}
		
		return servicioRegaloDAO.guardarRegalo(regalo);
	}

	@Override
	public List<Regalo> listarRegalosHechosPor(Usuario usuario) {
		return servicioRegaloDAO.listarRegalosHechosPor(usuario);
	}

	@Override
	public List<Regalo> listarRegalosRecibidosPor(String email) {
		return servicioRegaloDAO.listarRegalosRecibidosPor(email);
	}

	@Override
	public Integer cantRegalosHechosPor(Usuario usuario) {
		return servicioRegaloDAO.cantidadRegalosHechosPor(usuario);
	}

	@Override
	public Integer cantRegalosRecibidosPor(String email) {
		return servicioRegaloDAO.cantidadRegalosRecibidosPor(email);
	}

	@Override
	public Regalo buscarRegaloPorId(Integer id) {
		return servicioRegaloDAO.getRegaloById(id);
	}

	@Override
	public void elegirExperiencia(Integer idRegalo, Integer idExperiencia) throws Exception {
		Regalo regalo = servicioRegaloDAO.getRegaloById(idRegalo);
		Experiencia experiencia = servicioExperienciaDAO.findExperienceById(idExperiencia);
		if (regalo.getCanjeado() || experiencia == null)
			throw new Exception();

		regalo.setExperiencia(experiencia);
		regalo.setCanjeado(true);
		servicioRegaloDAO.update(regalo);

	}

	@Override
	public List<Experiencia> listarRegalosCanjeados(String email) {
		List<Regalo> regalosCanjeados = servicioRegaloDAO.listarRegalosCanjeados(email);
		List<Experiencia> experienciasCanjeadas = new ArrayList<Experiencia>();
		for(Regalo regalo : regalosCanjeados)
			experienciasCanjeadas.add(regalo.getExperiencia());
		return experienciasCanjeadas;
	}

	@Override
	public Boolean cambiarMeGusta(Integer id) {
		if(servicioExperienciaDAO.findExperienceById(id).getMeGusta()) {
			servicioExperienciaDAO.findExperienceById(id).setMeGusta(false);
			return true;
		} else {
			servicioExperienciaDAO.findExperienceById(id).setMeGusta(true);
			return false;	
		}
			
	}

	@Override
	public Object guardarRegalo(Integer nCaja, Long idRegalador, String mail) {
		return null;
	}
	
	@Override
	public Regalo buscarRegaloPorCupon(String cupon) {
		return servicioRegaloDAO.getRegaloByCupon(cupon);
	}
}
