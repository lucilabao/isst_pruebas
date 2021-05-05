package es.upm.dit.isst.barriocovid.dao;

import java.util.List;

import es.upm.dit.isst.barriocovid.model.USUARIO;

public interface USUARIODAO {

	public USUARIO create(USUARIO usuario);
	public USUARIO read(String email);
	public USUARIO update(USUARIO usuario);
	public USUARIO delete(USUARIO usuario);
	public List<USUARIO> readAll();
	public List<USUARIO> readAllVoluntario(String voluntario);
	public List<USUARIO> readAllVendedor(String vendedor);

}
