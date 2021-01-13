package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;

public class ControladorRegaloTest {

	@Test
	public void devolverUnMensajeDeExitoCuandoSeEligeUnaExperienciaValida() {
		ServicioRegalo servicioRegalo = mock(ServicioRegalo.class);
		
		ExperienciaForm expForm = mock(ExperienciaForm.class);
		Regalo regalo = mock(Regalo.class);
		String cuponRegalo = "AGBF2657JH";
		
		ControladorRegalo controlador = new ControladorRegalo(servicioRegalo);
		
		when(expForm.getCupon()).thenReturn(cuponRegalo);
		
		ModelAndView mav = controlador.confirmarExperiencia(expForm);
		
		assertThat(mav.getModel().get("ok")).isEqualTo("Ya puede canjear su regalo con el cupon " + cuponRegalo);
		assertThat(mav.getModel().get("error")).isNull();
	}
	
	@Test
	public void devolverUnMensajeDeErrorCuandoSeEligeUnaExperienciaCanjeada() {
		ServicioRegalo servicioRegalo = mock(ServicioRegalo.class);
		ExperienciaForm expForm = mock(ExperienciaForm.class);
		ControladorRegalo controlador = new ControladorRegalo(servicioRegalo);
		Regalo regalo = mock(Regalo.class);
		try {
			doThrow(Exception.class).when(servicioRegalo).elegirExperiencia(anyInt(), anyInt());
		} catch (Exception e) {
		}
		
		ModelAndView mav = controlador.confirmarExperiencia(expForm);
		
		assertThat(mav.getModel().get("error")).isEqualTo("No se pudo canjear el regalo, intente mas tarde.");
		assertThat(mav.getModel().get("ok")).isNull();
	}
	
	
	@Test
	public void testQueDirijaALaVistaDelResultadoFinal() {
		ServicioRegalo servicioRegalo = mock(ServicioRegalo.class);
		
		ExperienciaForm expForm = mock(ExperienciaForm.class);
		ControladorRegalo controlador = new ControladorRegalo(servicioRegalo);
		Regalo regalo = mock(Regalo.class);
		
		try {
			doThrow(Exception.class).when(servicioRegalo).elegirExperiencia(anyInt(), anyInt());
		} catch (Exception e) {
		}	
		
		ModelAndView mav = controlador.confirmarExperiencia(expForm);
		
		assertThat(mav.getViewName()).isEqualTo("pagina-resultado");
	}
	
	
	@Test
	public void testQuePruebeElMensajeAlRegalarCorrectamente() {
		ServicioRegalo servicioRegalo = mock(ServicioRegalo.class);
		
		RegaloForm regaloMock = mock(RegaloForm.class);
		
		ControladorRegalo controlador = new ControladorRegalo(servicioRegalo);
		
		String mail = "algo@algo.com";
		Integer nCaja = 1;
		Long idRegalador = 1L;
		
		when(servicioRegalo.guardarRegalo(nCaja, idRegalador, mail)).thenReturn(true);
		when(regaloMock.getIdRegalador()).thenReturn(idRegalador);
		when(regaloMock.getNumeroCajaDeRegalo()).thenReturn(nCaja);
		when(regaloMock.getEmail()).thenReturn(mail);
		
		ModelAndView mav = controlador.regalar(regaloMock);
		
		assertThat(mav.getModel().get("ok")).isEqualTo("Regalo enviado!"); 
		assertThat(mav.getViewName()).isEqualTo("pagina-resultado");
	}
}
