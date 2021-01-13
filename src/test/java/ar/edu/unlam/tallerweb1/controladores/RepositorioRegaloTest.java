package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegalo;

public class RepositorioRegaloTest extends SpringTest{
	
	@Autowired
	private RepositorioRegalo repo;
	@Test
	@Transactional @Rollback
	public void buscarRegaloPorSuRegalador() {
		Regalo regalo = new Regalo();
		Usuario florencia = new Usuario();
		florencia.setNombre("Florencia");
		florencia.setApellido("Lopez");
		florencia.setEmail("flora@gmail.com");
		florencia.setPassword("1234");
		florencia.setNombreUsuario("flora");
		session().save(florencia);
		
		Usuario carlos = new Usuario();
		carlos.setNombre("Florencia");
		carlos.setApellido("Lopez");
		carlos.setEmail("carlos@gmail.com");
		carlos.setPassword("1234");
		carlos.setNombreUsuario("carlos");
		session().save(carlos);
		
		CajaDeRegalo caja = new CajaDeRegalo();
		session().save(caja);
		
		regalo.setRegalador(carlos );
		regalo.setEmailDestinatario(florencia.getEmail());
		regalo.setCajaDeRegalo(caja);
		session().save(regalo);
		
		List<Regalo> found = repo.listarRegalosHechosPor(carlos);
		assertThat(found).hasSize(1);
	}

}
