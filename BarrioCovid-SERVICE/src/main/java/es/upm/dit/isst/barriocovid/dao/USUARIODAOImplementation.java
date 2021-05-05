package es.upm.dit.isst.barriocovid.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.barriocovid.model.USUARIO;


public class USUARIODAOImplementation implements USUARIODAO{
	private static  USUARIODAOImplementation instancia = null;
	  private USUARIODAOImplementation() {
	  }

	 public static USUARIODAOImplementation getInstance() {
	    if( null == instancia ) instancia = new USUARIODAOImplementation();
	    return instancia;
	  }
	 
	 @Override
	 public USUARIO create(USUARIO usuario) {
		  Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  	try {
		  		session.save(usuario);
		  	} catch (Exception e) {
		  		usuario = null;
		  	}
		  session.getTransaction().commit();
		  session.close();
		return usuario;
	 }
	 
	 public USUARIO read(String email) {
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 USUARIO usuario = session.get(USUARIO.class, email);
		 session.getTransaction().commit();
		 session.close();
		 return usuario;
	}
	 
	 public USUARIO update(USUARIO usuario) {
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 session.saveOrUpdate(usuario);
		 session.getTransaction().commit();
		 session.close();
		 return usuario;
	 } 
	 public USUARIO delete(USUARIO usuario) {
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 session.delete(usuario);
		 session.getTransaction().commit();
		 session.close();
		 return usuario;
	}
	 @SuppressWarnings("unchecked")
	 @Override
	 public List<USUARIO> readAll() {
		 List<USUARIO> usuarios = new ArrayList<USUARIO>();
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 usuarios.addAll(session.createQuery("from USUARIO").list());
		 session.getTransaction().commit();
		 session.close();
		 return usuarios;
	 }
	 @Override
	 public List<USUARIO> readAllVoluntario(String voluntario) {
		List<USUARIO> res = new ArrayList<USUARIO>();
		for(USUARIO usuario : this.readAll()) {
			if(usuario.getRol().contentEquals(voluntario)) {
				res.add(usuario);
			}
		}
		return res;
	}
	 @Override
	 public List<USUARIO> readAllVendedor(String vendedor) {
		List<USUARIO> res = new ArrayList<USUARIO>();
		for(USUARIO usuario : this.readAll()) {
			if(usuario.getRol().contentEquals(vendedor)) {
				res.add(usuario);
			}
		}
		return res;
	}
	 
	 
}
