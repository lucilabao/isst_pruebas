package es.upm.dit.isst.barriocovid.dao;

import java.util.List;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;



public interface BarrioCovidDAO {
	
	
//	public TFG create(TFG tfg);
//	public TFG read(String email);
//	public TFG update(TFG tfg);
//	public TFG delete(TFG tfg);
	
	public List<BarrioCovid>  readAll();
	//public List<TFG>  readAll(String professor);	


}
