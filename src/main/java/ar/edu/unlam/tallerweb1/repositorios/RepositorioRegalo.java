package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioRegalo {
	Boolean guardarRegalo(Regalo regalo);

	List<Regalo> listarRegalosHechosPor(Usuario usuario);

	List<Regalo> listarRegalosRecibidosPor(String email);

	Integer cantidadRegalosHechosPor(Usuario usuario);

	Integer cantidadRegalosRecibidosPor(String email);

	Regalo getRegaloById(Integer id);
	
	void update(Regalo regalo);

	List<Regalo> listarRegalosCanjeados(String email);

	Regalo getRegaloByCupon(String cupon);
}
