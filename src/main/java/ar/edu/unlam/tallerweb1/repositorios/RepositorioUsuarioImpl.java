package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword())).uniqueResult();
	}

	@Override
	public Boolean guardarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
		Usuario user = consultarUsuario(usuario);
		return user != null ? true : false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean buscarUsuarioPorNombreUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		Usuario userBuscado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombreUsuario", usuario.getNombreUsuario())).uniqueResult();
		return userBuscado != null ? true : false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario buscarUsuarioPorEmail(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario getUsuarioPorUsername(String username) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("nombreUsuario", username))
				.uniqueResult();
	}

	@Override
	public Boolean checkUserByEmail(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Usuario.class).add(Restrictions.eq("email", email)).uniqueResult() != null;
	}

	@Override
	public Usuario getUserByEmail(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public Usuario getUserById(long idRegalador) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("id", idRegalador)).uniqueResult();
	}


}