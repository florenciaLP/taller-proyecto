package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	private ServicioUsuario servicioUsuario;
	private ServicioRegalo servicioRegalo;

	@Autowired
	public ControladorUsuario(ServicioUsuario servicioUsuario, ServicioRegalo servicioRegalo) {
		this.servicioUsuario = servicioUsuario;
		this.servicioRegalo = servicioRegalo;
	}

	@RequestMapping("perfil")
    public ModelAndView irAlPerfil(HttpServletRequest request) {
        Object usuario = request.getSession().getAttribute("IDUSUARIO");

        if (usuario == null)
            return new ModelAndView("redirect:/registrarse");

        ModelMap model = new ModelMap();
        Usuario usuarioExistente = servicioUsuario.getUsuarioById(Long.parseLong(usuario.toString()));
        model.put("usuario", usuarioExistente);

        List<Regalo> listarRegalosHechos = servicioRegalo.listarRegalosHechosPor(usuarioExistente);
        List<Regalo> listarRegaloRecibidos = servicioRegalo.listarRegalosRecibidosPor(usuarioExistente.getEmail());
        List<Experiencia> listarRegaloCanjeados = servicioRegalo.listarRegalosCanjeados(usuarioExistente.getEmail());

        model.put("listaHechos", listarRegalosHechos);
        model.put("listaRecibido", listarRegaloRecibidos);
        model.put("listaCanjeados", listarRegaloCanjeados);
        model.put("Experiencia", new Experiencia());

        Integer cantRegalosHechos = servicioRegalo.cantRegalosHechosPor(usuarioExistente);
        Integer cantRegaloRecibidos = servicioRegalo.cantRegalosRecibidosPor(usuarioExistente.getEmail());
        model.put("cantRecibido", cantRegaloRecibidos);
        model.put("cantHechos", cantRegalosHechos);
        model.put("CajaDeRegalo", new CajaDeRegalo());
        Long valor = Long.parseLong(usuario.toString());
        model.put("usuario", servicioUsuario.getUsuarioById(valor));        
        model.put("Regalo", new Regalo());

        return new ModelAndView("perfil", model);
    }

	@RequestMapping(value = "cambiarMeGusta", method = RequestMethod.POST)
	public ModelAndView cambiarMeGusta(@ModelAttribute("Experiencia") Experiencia experincia) {
		servicioRegalo.cambiarMeGusta(experincia.getId());
		return new ModelAndView("redirect:/perfil");
	}

	private Usuario obtenerUsuarioActual(HttpServletRequest request) {
		return servicioUsuario
				.getUsuarioById(Long.parseLong(request.getSession().getAttribute("IDUSUARIO").toString()));
	}

	private boolean usuarioNoEstaLogueado(HttpServletRequest request) {
		return request.getSession().getAttribute("IDUSUARIO") == null;
	}

}