package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.ExperienciaForm;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("repositorioRegalo")
public class RepositorioRegaloImpl implements RepositorioRegalo {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioRegaloImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean guardarRegalo(Regalo regalo) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(regalo);
		Regalo regaloCreado = getRegaloById(regalo.getId());
		return regaloCreado != null;
	}

	@Override
	public Regalo getRegaloById(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		return session.get(Regalo.class, id);
	}

	@Override
	public List<Regalo> listarRegalosHechosPor(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		List<Regalo> regalos = session.createCriteria(Regalo.class).add(Restrictions.eq("regalador", usuario)).list();
		return regalos;
	}

	@Override
	public List<Regalo> listarRegalosRecibidosPor(String email) {
		final Session session = sessionFactory.getCurrentSession();
		List<Regalo> regalos = session.createCriteria(Regalo.class).add(Restrictions.eq("emailDestinatario", email))
				.add(Restrictions.eq("canjeado", false))
				.list();
		return regalos;
	}

	@Override
	public Integer cantidadRegalosHechosPor(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		return listarRegalosHechosPor(usuario).size();
	}

	@Override
	public Integer cantidadRegalosRecibidosPor(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return listarRegalosRecibidosPor(email).size();
	}
	
	@Override
	public void update(Regalo regalo) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(regalo);
	}

	@Override
	public List<Regalo> listarRegalosCanjeados(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Regalo.class).add(Restrictions.eq("emailDestinatario", email))
				.add(Restrictions.eq("canjeado", true))
				.list();
	}
	
	@Override
	public Regalo getRegaloByCupon(String cupon) {
		final Session session = sessionFactory.getCurrentSession();
		return (Regalo) session.createCriteria(Regalo.class).add(Restrictions.eq("cupon", cupon)).uniqueResult();
	}

}
