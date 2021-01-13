package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;

public interface RepositorioCajaDeRegalo {
	List<CajaDeRegalo> obtenerLista();
	CajaDeRegalo buscarCajaPorNumero(Integer numeroCaja);	
	Boolean crearCajaDeRegalo(CajaDeRegalo cajaDeRegalo);
	List<Experiencia> listarExperiencias(Integer numeroDeCaja);
}
