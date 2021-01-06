package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	private RepositorioUsuario servicioUsuarioDAO;

	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario servicioUsuarioDAO) {
		this.servicioUsuarioDAO = servicioUsuarioDAO;
	}

	@Override
	public Usuario getUsuarioPorNombreUsuario(String username) {
		// TODO Auto-generated method stub
		return servicioUsuarioDAO.getUsuarioPorUsername(username);
	}

	@Override
	public Boolean checkUserByEmail(String email) {
		return servicioUsuarioDAO.checkUserByEmail(email);
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		return servicioUsuarioDAO.getUserByEmail(email);
	}

	@Override
	public Usuario getUsuarioById(long idRegalador) {
		// TODO Auto-generated method stub
		return servicioUsuarioDAO.getUserById(idRegalador);
	}
}
