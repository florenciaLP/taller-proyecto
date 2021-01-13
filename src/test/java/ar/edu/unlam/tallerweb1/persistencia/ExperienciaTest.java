package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import junit.extensions.TestSetup;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ExperienciaTest extends SpringTest{
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
    
    @Test(expected= Exception.class) @Transactional @Rollback
	public void queNoSePuedaGuardarUnaExperienciaSinCajaDeRegalo() throws Exception {
    	final Session session = session();
		Experiencia experiencia = new Experiencia();
		session.save(experiencia);
	}
    
    @Test @Transactional @Rollback
	public void queSeGuardeLaExperienciaConSuCaja() throws Exception {
    	final Session session = session();
    	
		Experiencia experiencia = new Experiencia();
		CajaDeRegalo caja = new CajaDeRegalo();
		session.save(caja);
		
		experiencia.setCajaDeRegalo(caja);
		session.save(experiencia);
		
		Experiencia experienciaDB = session.get(Experiencia.class, experiencia.getId());
		assertThat(experienciaDB.getCajaDeRegalo()).isNotNull();
		assertThat(experienciaDB.getCajaDeRegalo()).isEqualTo(caja);
	}
}
