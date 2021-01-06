package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCajaDeRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControladorCajadeRegaloTest {
	
	@Test
	public void validarLogin() {
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		ServicioUsuario servicioUsuarioMock = mock(ServicioUsuario.class);
		Usuario usuarioMock = mock (Usuario.class);
		HttpServletRequest requestMock = mock (HttpServletRequest.class);
		HttpSession sessionMock = mock (HttpSession.class);
		
		ControladorLogin controladorLogin = new ControladorLogin(servicioLoginMock,servicioUsuarioMock);
		
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
		when(usuarioMock.getRol()).thenReturn("ADMIN");
		
		ModelAndView mav = controladorLogin.validarLogin(usuarioMock, requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("login");
		assertThat(mav.getModel().get("error")).isEqualTo("Usuario o clave incorrecta");
		
		verify(sessionMock, times(0)).setAttribute("ROL", "ADMIN");
		
	}
	
	@Test
	public void testQueDireccioneAlDetalleDeUnaCajaDeRegaloSeleccionada() {
		ServicioCajaDeRegalo servicioCajaDeRegaloMock = mock(ServicioCajaDeRegalo.class);
		ServicioRegalo servicioRegaloMock = mock(ServicioRegalo.class);
		CajaDeRegalo cajaMock = mock(CajaDeRegalo.class);
		
		List<Experiencia> experienciaMock = new ArrayList<Experiencia>();
		Integer numeroDeCaja = 1;
		
			
		ControladorCajaDeRegalo controladorCaja = new ControladorCajaDeRegalo(servicioCajaDeRegaloMock, servicioRegaloMock);
		
		when(cajaMock.getNumeroDeCaja()).thenReturn(numeroDeCaja);
		when(servicioCajaDeRegaloMock.buscarCajaPorNumero(numeroDeCaja)).thenReturn(cajaMock);
		when(servicioCajaDeRegaloMock.listarExperiencias(cajaMock.getNumeroDeCaja())).thenReturn(experienciaMock);
		
		
		ModelAndView mav = controladorCaja.detalleDeCaja(cajaMock);
		
		assertThat(mav.getViewName()).isEqualTo("caja-seleccionada");
	}
	
	@Test
	public void testQueAlIngresarEnLaHomeMuestreCajasDeRegalo() {
		ServicioCajaDeRegalo servicioCajaDeRegaloMock = mock(ServicioCajaDeRegalo.class);
		ServicioRegalo servicioRegaloMock = mock(ServicioRegalo.class);
		CajaDeRegalo cajaMock = mock(CajaDeRegalo.class);
		List<CajaDeRegalo> cajasMock = new ArrayList<CajaDeRegalo>();

		
		ControladorCajaDeRegalo controladorCaja = new ControladorCajaDeRegalo(servicioCajaDeRegaloMock, servicioRegaloMock);
		
		when(servicioCajaDeRegaloMock.obtenerLista()).thenReturn(cajasMock);
		
		
		ModelAndView mav = controladorCaja.mostrarCajas();
		
		assertThat(mav.getViewName()).isEqualTo("home");
		
	}
	
	
	@Test
	public void testQueTeDirijaALaVistaDelRegalo() {
		ServicioCajaDeRegalo servicioCajaDeRegaloMock = mock(ServicioCajaDeRegalo.class);
		ServicioRegalo servicioRegaloMock = mock(ServicioRegalo.class);
		
		CajaDeRegalo cajaMock = mock(CajaDeRegalo.class);
		
		ControladorCajaDeRegalo controladorCaja = new ControladorCajaDeRegalo(servicioCajaDeRegaloMock, servicioRegaloMock);
		
		ModelAndView mav = controladorCaja.regaloForm(null);
		
		assertThat(mav.getViewName()).isEqualTo("regalo-pagina");
	}
}
