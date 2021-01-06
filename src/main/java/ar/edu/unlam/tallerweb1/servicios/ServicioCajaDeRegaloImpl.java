package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCajaDeRegalo;

@Service
@Transactional
public class ServicioCajaDeRegaloImpl implements ServicioCajaDeRegalo {

	private RepositorioCajaDeRegalo servicioCajaDeRegaloDAO;

	@Autowired
	public ServicioCajaDeRegaloImpl(RepositorioCajaDeRegalo servicioCajaDeRegaloDAO) {
		this.servicioCajaDeRegaloDAO = servicioCajaDeRegaloDAO;
	}

	@Override
	public List<CajaDeRegalo> obtenerLista() {
		// TODO Auto-generated method stub
		return servicioCajaDeRegaloDAO.obtenerLista();
	}

	@Override
	public CajaDeRegalo buscarCajaPorNumero(Integer numeroCaja) {
		return this.servicioCajaDeRegaloDAO.buscarCajaPorNumero(numeroCaja);
	}

	@Override
	public Boolean crearCajaDeRegalo(CajaDeRegalo cajaDeRegalo) {
		return this.servicioCajaDeRegaloDAO.crearCajaDeRegalo(cajaDeRegalo);
	}

	@Override
	public List<Experiencia> listarExperiencias(Integer numeroDeCaja) {
		return servicioCajaDeRegaloDAO.listarExperiencias(numeroDeCaja);
	}
}
