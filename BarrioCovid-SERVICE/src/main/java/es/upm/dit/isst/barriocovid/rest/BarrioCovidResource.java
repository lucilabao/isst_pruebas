package es.upm.dit.isst.barriocovid.rest;

//import java.net.URI;
//import java.net.URISyntaxException;
import java.util.List;

//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;

//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import javax.ws.rs.core.Response;

import es.upm.dit.isst.barriocovid.dao.BarrioCovidDAOImplementation;
import es.upm.dit.isst.barriocovid.model.BarrioCovid;


@Path("/COVID")
public class BarrioCovidResource {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BarrioCovid> readAll() {
	
		return BarrioCovidDAOImplementation.getInstance().readAll();//Usa el CRUD: readAll()
		
	}

}
