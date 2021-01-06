package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Prestador;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;

@Controller
public class ControladorRegalo {

	private ServicioRegalo servicioRegalo;

	@Autowired
	public ControladorRegalo(ServicioRegalo servicioRegalo) {
		this.servicioRegalo = servicioRegalo;
	}

	@RequestMapping(value = "hacerRegalo", method = RequestMethod.POST)
	public ModelAndView regalar(@ModelAttribute("RegaloForm") RegaloForm regaloForm) {

		try {
			servicioRegalo.guardarRegalo(regaloForm);
		} catch (Exception e) {
			return resultadoConMensaje("error", "No se ha podido enviar el regalo, intentalo nuevamente");
		}

		if (noExisteUsuario(regaloForm))
			return resultadoConMensaje("error", "Para realizar un regalo primero debes registrarte");

		else if (emailEsInvalido(regaloForm))
			return resultadoConMensaje("error", "Debe ingresar un email valido");

		else
			return resultadoConMensaje("ok", "Regalo enviado!");
	}

	private boolean emailEsInvalido(RegaloForm regaloForm) {
		return regaloForm.getEmail().isEmpty() || !regaloForm.getEmail().contains("@");
	}

	private boolean noExisteUsuario(RegaloForm regaloForm) {
		return regaloForm.getIdRegalador() == 0;
	}

	private ModelAndView resultadoConMensaje(String resultado, String mensaje) {
		return new ModelAndView("pagina-resultado", new ModelMap(resultado, mensaje));
	}

	@RequestMapping(value = "elegirExperiencia", method = RequestMethod.POST)
	public ModelAndView confirmarExperiencia(@ModelAttribute("experienciaForm") ExperienciaForm expForm) {
		ModelMap model = new ModelMap();

		try {
			servicioRegalo.elegirExperiencia(expForm.getIdRegalo(), expForm.getIdExp());
			model.put("ok", "Ya puede canjear su regalo con el cupon " + expForm.getCupon());

		} catch (Exception e) {
			model.put("error", "No se pudo canjear el regalo, intente mas tarde.");
		}
		return new ModelAndView("pagina-resultado", model);
	}

}