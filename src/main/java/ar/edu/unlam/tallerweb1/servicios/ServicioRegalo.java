package ar.edu.unlam.tallerweb1.servicios;

import java.io.IOException;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegalo {
	Boolean guardarRegalo(RegaloForm regaloForm) throws IOException;

	List<Regalo> listarRegalosHechosPor(Usuario usuario);

	List<Regalo> listarRegalosRecibidosPor(String email);

	Integer cantRegalosHechosPor(Usuario usuario);

	Integer cantRegalosRecibidosPor(String email);

	Regalo buscarRegaloPorId(Integer id);
	
	Regalo buscarRegaloPorCupon(String cupon);

	void elegirExperiencia(Integer idRegalo, Integer idExperiencia) throws Exception;

	List<Experiencia> listarRegalosCanjeados(String email);

	Boolean cambiarMeGusta(Integer id);
	Object guardarRegalo(Integer nCaja, Long idRegalador, String mail);

}
