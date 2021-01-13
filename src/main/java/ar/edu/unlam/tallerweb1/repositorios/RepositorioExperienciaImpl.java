package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.Regalo;

@Repository("repositorioExperiencia")
public class RepositorioExperienciaImpl implements RepositorioExperiencia {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioExperienciaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Experiencia findExperienceById(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		return session.get(Experiencia.class, id);
	}
}
