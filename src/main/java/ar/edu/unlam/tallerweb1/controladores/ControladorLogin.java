package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {

	private ServicioLogin servicioLogin;
	private ServicioUsuario servicioUsuario;


	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioUsuario servicioUsuario) {
		this.servicioLogin = servicioLogin;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping("/entrar")
	public ModelAndView irALogin() {
		Usuario usuario = new Usuario();
		return irALogin("usuario", usuario);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);

		if (existe(usuarioBuscado)) {
			setearValoresDeLogin(request, usuarioBuscado);
			return inicio();

		} else
			return resultadoConMensajeEnLogin("error", "Usuario o clave incorrecta");
	}

	private boolean existe(Usuario usuarioBuscado) {
		return usuarioBuscado != null;
	}

	private void setearValoresDeLogin(HttpServletRequest request, Usuario usuarioBuscado) {
		request.getSession().setAttribute("USERNAME", usuarioBuscado.getNombreUsuario());
		request.getSession().setAttribute("IDUSUARIO", usuarioBuscado.getId());
	}

	private Boolean buscarUsuarioPorEmail(Usuario usuario) {
		Usuario usuarioBuscado = servicioLogin.buscarUsuarioPorEmail(usuario);
		return existe(usuarioBuscado);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(path = "/registrarse", method = RequestMethod.GET)
	public ModelAndView irARegistrarse() {
		Usuario usuario = new Usuario();
		return irARegistrarse("usuario", usuario);
	}

	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		if (siElEmailLoTieneOtro(usuario))
			return resultadoConMensajeEnRegistrarse("error", "Ya existe un usuario con ese email");

		else if (siElNombreUsuarioLoTieneOtro(usuario))
			return resultadoConMensajeEnRegistrarse("error", "El nombre de usuario ya existe");

		else if (noSeCompletaronTodosLosDatos(usuario))
			return resultadoConMensajeEnRegistrarse("error", "Debe completar todos los campos");

		else
			return darDeAlta(usuario);
	}

	private ModelAndView darDeAlta(Usuario usuario) {
		if (servicioLogin.guardarUsuario(usuario))
			return new ModelAndView("redirect:/entrar");

		else
			return resultadoConMensajeEnRegistrarse("error", "No se pudo guardar el registro");
	}

	private boolean noSeCompletaronTodosLosDatos(Usuario usuario) {
		return servicioLogin.verificarSiValoresNulos(usuario);
	}

	private Boolean siElNombreUsuarioLoTieneOtro(Usuario usuario) {
		return servicioLogin.buscarUsuarioPorNombreUsuario(usuario);
	}

	private ModelAndView resultadoConMensajeEnRegistrarse(String resultado, String mensaje) {
		return new ModelAndView("registrarse", new ModelMap(resultado, mensaje));
	}
	
	private ModelAndView resultadoConMensajeEnLogin(String resultado, String mensaje) {
		return new ModelAndView("login", new ModelMap(resultado, mensaje));
	}

	private ModelAndView irARegistrarse(String resultado, Usuario usuario) {
		return new ModelAndView("registrarse", new ModelMap(resultado, usuario));
	}

	private ModelAndView irALogin(String resultado, Usuario usuario) {
		return new ModelAndView("login", new ModelMap(resultado, usuario));
	}

	private Boolean siElEmailLoTieneOtro(Usuario usuario) {
		return buscarUsuarioPorEmail(usuario);
	}

	@RequestMapping("logout")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().invalidate();
		return inicio();
	}
}