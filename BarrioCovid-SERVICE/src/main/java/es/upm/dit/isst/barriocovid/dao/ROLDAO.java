package es.upm.dit.isst.barriocovid.dao;

import java.util.List;

import es.upm.dit.isst.barriocovid.model.ROL;

public interface ROLDAO {

	public ROL createROL(ROL rol);
	public ROL readROL(String email);
	public ROL updateROL(ROL rol);
	public ROL deleteROL(ROL rol);
	public List<ROL> readAllROL();

}
