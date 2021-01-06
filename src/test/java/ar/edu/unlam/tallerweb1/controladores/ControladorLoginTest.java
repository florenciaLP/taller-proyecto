package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorLoginTest {

	@Test
	public void validarLoginSiUsuarioNoExiste() {
		
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		Usuario usuarioMock = mock(Usuario.class);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		ControladorLogin controladorLogin = new ControladorLogin(servicioLoginMock, null);

		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
		when(usuarioMock.getRol()).thenReturn("ADMIN");
		
		ModelAndView mav = controladorLogin.validarLogin(usuarioMock, requestMock);
		assertThat(mav.getViewName()).isEqualTo("login");
		assertThat(mav.getModel().get("error")).isEqualTo("Usuario o clave incorrecta");
		verify(sessionMock, times(0)).setAttribute("ROL","ADMIN");
		
	}
	
	@Test
	public void validarLoginConUsuarioYPasswordCorrectos() {
		
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		Usuario usuarioMock = mock(Usuario.class);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		ControladorLogin controladorLogin = new ControladorLogin(servicioLoginMock, null);
		ModelMap modelMock = mock(ModelMap.class);
		
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(usuarioMock.getRol()).thenReturn("ADMIN");
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		
		
		ModelAndView mav = controladorLogin.validarLogin(usuarioMock, requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("redirect:/home");
		verify(sessionMock, times(1)).setAttribute("ROL","ADMIN");
		verify(modelMock, times(0)).put("error", "Usuario o clave incorrecta");
		
	}
	
	@Test
	public void testIrAlPerfilConSusListas() {
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		ServicioUsuario servicioUsuarioMock = mock(ServicioUsuario.class);
		ServicioRegalo servicioRegaloMock = mock(ServicioRegalo.class);
		Usuario usuarioMock = mock(Usuario.class);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		ModelMap modelMock = mock(ModelMap.class);
		
		
		ControladorUsuario controladorUsuario = new ControladorUsuario(servicioUsuarioMock,servicioRegaloMock);
		
	
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(usuarioMock.getRol()).thenReturn("ADMIN");
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		
		
		ModelAndView mav = controladorUsuario.irAlPerfil(requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("perfil");
		verify(sessionMock, times(1)).setAttribute("ROL","ADMIN");
		verify(modelMock, times(0)).put("error", "Usuario o clave incorrecta");
		
	}
}