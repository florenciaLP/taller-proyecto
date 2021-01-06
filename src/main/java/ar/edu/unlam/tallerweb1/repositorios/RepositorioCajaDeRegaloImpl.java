package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;

@Repository("repositorioCajaDeRegalo")
public class RepositorioCajaDeRegaloImpl implements RepositorioCajaDeRegalo {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioCajaDeRegaloImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<CajaDeRegalo> obtenerLista() {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(CajaDeRegalo.class).list();
	}

	@Override
	public CajaDeRegalo buscarCajaPorNumero(Integer numeroCaja) {
		final Session session = sessionFactory.getCurrentSession();
		return (CajaDeRegalo) session
				.createCriteria(CajaDeRegalo.class)
				.add(Restrictions.eq("numeroDeCaja", numeroCaja))
				.uniqueResult();
	}

	@Override
	public Boolean crearCajaDeRegalo(CajaDeRegalo cajaDeRegalo) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.save(cajaDeRegalo);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Experiencia> listarExperiencias(Integer numeroDeCaja) {
		final Session session = sessionFactory.getCurrentSession();
		return  session
				.createCriteria(Experiencia.class)
				.createAlias("cajaDeRegalo", "CajaDeRegalo")
				.add(Restrictions.eq("CajaDeRegalo.numeroDeCaja", numeroDeCaja)) //con esto evitamos utilizar otra query "buscarCajaPorNumero"
				.list();
	}

}



