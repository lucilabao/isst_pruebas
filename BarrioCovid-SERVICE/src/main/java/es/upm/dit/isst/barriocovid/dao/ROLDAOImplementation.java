package es.upm.dit.isst.barriocovid.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.barriocovid.model.ROL;

public class ROLDAOImplementation {
	private static  ROLDAOImplementation instancia = null;
	private ROLDAOImplementation() {
	}

	public static ROLDAOImplementation getInstance() {
		if( null == instancia ) instancia = new ROLDAOImplementation();
		return instancia;
	}

	public ROL createROL(ROL rol) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
			session.save(rol);
		} catch (Exception e) {
			rol = null;
		}
		session.getTransaction().commit();
		session.close();
		return rol;
	}

	public ROL readROL(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ROL rol = session.get(ROL.class, email);
		session.getTransaction().commit();
		session.close();
		return rol;
	}

	public ROL updateROL(ROL rol) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(rol);
		session.getTransaction().commit();
		session.close();
		return rol;
	} 
	public ROL deleteROL(ROL rol) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(rol);
		session.getTransaction().commit();
		session.close();
		return rol;
	}

	@SuppressWarnings("unchecked")
	public List<ROL> readAllROL() {
		List<ROL> roles = new ArrayList<ROL>();
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		roles.addAll(session.createQuery("from ROL").list());
		session.getTransaction().commit();
		session.close();
		return roles;
	}


}
