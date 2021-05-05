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

import es.upm.dit.isst.barriocovid.dao.USUARIODAOImplementation;
import es.upm.dit.isst.barriocovid.model.USUARIO;

@Path("/PEDIDOs")
public class USUARIOResource {
		//USUARIOs
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<USUARIO> readAll () {
			return USUARIODAOImplementation.getInstance().readAll();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response create(USUARIO unew) throws URISyntaxException {
			USUARIO u = USUARIODAOImplementation.getInstance().create(unew);
			if (u != null) {
				URI uri = new URI("/BarrioCovid-SERVICE/rest/USUARIOs/" + u.getEmail());
					return Response.created(uri).build();
		    }
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		//USUARIOs/id
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response read(@PathParam("id") String id) {
			USUARIO u = USUARIODAOImplementation.getInstance().read(id);
			if (u == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			return Response.ok(u, MediaType.APPLICATION_JSON).build();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("{id}")
		public Response update(@PathParam("id") String id, USUARIO u) {
			System.out.println("Update request for" + id + " " + u.toString());
			USUARIO told = USUARIODAOImplementation.getInstance().read(id);
			if ((told == null) || (!
					told.getEmail().contentEquals(u.getEmail())))
				return Response.notModified().build();
			USUARIODAOImplementation.getInstance().update(u); return Response.ok().build(); 
		}
		@DELETE
		@Path("{id}")
		public Response delete(@PathParam("id") String id) {
			USUARIO rold = USUARIODAOImplementation.getInstance().read(id);
			if (rold == null)
				return Response.notModified().build();
			USUARIODAOImplementation.getInstance().delete(rold);
			return Response.ok().build();
		}
		//PEDIDOs/voluntario/id
		@GET
		@Path("voluntario/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<USUARIO> readAllVoluntario (@PathParam("id") String id) {
			return USUARIODAOImplementation.getInstance().readAllVoluntario(id);
		}
		//USUARIOs/vendedor/id
		@GET
		@Path("vendedor/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<USUARIO> readAllVendedor (@PathParam("id") String id) {
			return USUARIODAOImplementation.getInstance().readAllVendedor(id);
		}


}

