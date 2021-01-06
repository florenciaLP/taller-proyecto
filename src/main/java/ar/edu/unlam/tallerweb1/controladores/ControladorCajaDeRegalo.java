package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
import ar.edu.unlam.tallerweb1.servicios.ServicioCajaDeRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;

@Controller
public class ControladorCajaDeRegalo {

	private ServicioCajaDeRegalo servicioCaja;
	private ServicioRegalo servicioRegalo;

	@Autowired
	public ControladorCajaDeRegalo(ServicioCajaDeRegalo servicioCaja, ServicioRegalo servicioRegalo) {
		this.servicioCaja = servicioCaja;
		this.servicioRegalo = servicioRegalo;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mostrarCajas() {
		ModelMap model = new ModelMap();

		List<CajaDeRegalo> cajas = servicioCaja.obtenerLista();
		model.put("cajas", cajas);

		CajaDeRegalo caja = new CajaDeRegalo();
		model.put("CajaDeRegalo", caja);

		return new ModelAndView("home", model);
	}

	@RequestMapping(value = "mostrarCaja", method = RequestMethod.POST)
	public ModelAndView detalleDeCaja(@ModelAttribute("CajaDeRegalo") CajaDeRegalo caja) {
		ModelMap model = new ModelMap();

		model.put("caja", cajaSeleccionada(caja));
		model.put("experiencias", experienciasDeLaCaja(caja));
		model.put("RegaloForm", new RegaloForm());

		return new ModelAndView("caja-seleccionada", model);
	}

	private List<Experiencia> experienciasDeLaCaja(CajaDeRegalo caja) {
		return servicioCaja.listarExperiencias(cajaSeleccionada(caja).getNumeroDeCaja());
	}

	private CajaDeRegalo cajaSeleccionada(CajaDeRegalo caja) {
		return servicioCaja.buscarCajaPorNumero(caja.getNumeroDeCaja());
	}

	@RequestMapping(value="/canjearRegalo", method= RequestMethod.POST)
	public ModelAndView elegirExperiencia(@ModelAttribute("Regalo") Regalo regalo, HttpServletRequest request) {
		Object usuario = request.getSession().getAttribute("IDUSUARIO");
		ModelMap model = new ModelMap();
		String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		if (usuario == null) {
			request.getSession().setAttribute("PaginaAnterior", "canjearRegalo");
			return new ModelAndView("redirect:/entrar", model);
		}
		
		Regalo regaloObtenido = servicioRegalo.buscarRegaloPorId(regalo.getId());
		CajaDeRegalo caja = regaloObtenido.getCajaDeRegalo();
		List<Experiencia> experiencias = servicioCaja.listarExperiencias(caja.getNumeroDeCaja());
		model.put("caja", caja);
		model.put("experiencias", experiencias);
		model.put("Regalo", regaloObtenido);
		model.put("experienciaForm", new ExperienciaForm());
		
		return new ModelAndView("canje-del-regalo",model);
	}
	
	@RequestMapping(value="/{cupon}", method= RequestMethod.GET)
	public ModelAndView elegirExperiencia2(HttpServletRequest request, @ModelAttribute("cupon") String cupon) {
		Object usuario = request.getSession().getAttribute("IDUSUARIO");
		ModelMap model = new ModelMap();
		String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		if (usuario == null) {
			request.getSession().setAttribute("PaginaAnterior", "canjearRegalo");
			return new ModelAndView("redirect:/entrar", model);
		}
		
		Regalo regaloObtenido = servicioRegalo.buscarRegaloPorCupon(cupon);
		
		if(regaloObtenido.getCanjeado()) {
			model.put("error", "Este cupon ya fue canjeado");
			return new ModelAndView("pagina-resultado", model);
		}
			
		CajaDeRegalo caja = regaloObtenido.getCajaDeRegalo();
		List<Experiencia> experiencias = servicioCaja.listarExperiencias(caja.getNumeroDeCaja());
		model.put("caja", caja);
		model.put("experiencias", experiencias);
		model.put("Regalo", regaloObtenido);
		model.put("experienciaForm", new ExperienciaForm());
		
		return new ModelAndView("canje-del-regalo",model);
	}

	private List<Experiencia> experienciasACanjear(Regalo regalo) {
		return servicioCaja.listarExperiencias(cajaRegalada(regalo).getNumeroDeCaja());
	}

	private CajaDeRegalo cajaRegalada(Regalo regalo) {
		return regaloACanjear(regalo).getCajaDeRegalo();
	}

	private Regalo regaloACanjear(Regalo regalo) {
		return servicioRegalo.buscarRegaloPorId(regalo.getId());
	}

	@RequestMapping("/regalo-form")
	public ModelAndView regaloForm(Model model) {
		return new ModelAndView("regalo-pagina", new ModelMap("regalo", new CajaDeRegalo()));
	}

	@RequestMapping("/submitForm")
	public String submitForm(@ModelAttribute("regalo") CajaDeRegalo reg) {
		return "confirmacion-regalo";
	}

	@RequestMapping(value = "/crear-cajaDeRegalo", method = RequestMethod.GET)
	public ModelAndView vistaCrearCategoria() {
		return new ModelAndView("crear-caja-regalo", new ModelMap("cajaDeRegalo", new CajaDeRegalo()));
	}

}
