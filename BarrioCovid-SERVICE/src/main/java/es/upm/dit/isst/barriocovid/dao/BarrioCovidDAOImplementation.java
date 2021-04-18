package es.upm.dit.isst.barriocovid.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;




public class BarrioCovidDAOImplementation implements BarrioCovidDAO {

	private static BarrioCovidDAOImplementation instancia = null;
	
	private BarrioCovidDAOImplementation() {

	}
	
	public static BarrioCovidDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new BarrioCovidDAOImplementation();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BarrioCovid> readAll() {

		List<BarrioCovid> lista = new ArrayList<BarrioCovid>();
		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		lista.addAll(session.createQuery("from BarrioCovid").list());
		session.getTransaction().commit();

		session.close();
		return lista;

	}
	
	

	
}
