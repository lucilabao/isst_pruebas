package es.upm.dit.isst.barriocovid.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.dit.isst.barriocovid.dao.ROLDAOImplementation;
import es.upm.dit.isst.barriocovid.model.ROL;

@Path("/ROLes")
public class ROLResource {
		//ROLes
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<ROL> readAllROL() {
			return ROLDAOImplementation.getInstance().readAllROL();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createUSUARIO(ROL rnew) throws URISyntaxException {
			ROL r = ROLDAOImplementation.getInstance().createROL(rnew);
			if (r != null) {
				URI uri = new URI("/BarrioCovid-SERVICE/rest/ROLes/" + r.getEmail());
					return Response.created(uri).build();
		    }
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		//ROLes/id
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response readROL(@PathParam("id") String id) {
			ROL r = ROLDAOImplementation.getInstance().readROL(id);
			if (r == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			return Response.ok(r, MediaType.APPLICATION_JSON).build();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("{id}")
		public Response updateROL(@PathParam("id") String id, ROL r) {
			System.out.println("Update request for" + id + " " + r.toString());
			ROL told = ROLDAOImplementation.getInstance().readROL(id);
			if ((told == null) || (!
					told.getEmail().contentEquals(r.getEmail())))
				return Response.notModified().build();
			ROLDAOImplementation.getInstance().updateROL(r); return Response.ok().build(); 
		}
		@DELETE
		@Path("{id}")
		public Response deleteROL(@PathParam("id") String id) {
			ROL rold = ROLDAOImplementation.getInstance().readROL(id);
			if (rold == null)
				return Response.notModified().build();
			ROLDAOImplementation.getInstance().deleteROL(rold);
			return Response.ok().build();
		}

}
