package es.upm.dit.isst.pedido.rest;

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

import es.upm.dit.isst.pedido.dao.PEDIDODAOImplementation;
import es.upm.dit.isst.pedido.model.PEDIDO;


@Path("/PEDIDOs")
public class PEDIDOResource {

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<PEDIDO> readAll () {
			return PEDIDODAOImplementation.getInstance().readAll();
		}
		@GET
		@Path("vendedor/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<PEDIDO> readAllVendedor (@PathParam("id") String id) {
			return PEDIDODAOImplementation.getInstance().readAllVendedor(id);
		}
		@GET
		@Path("voluntario/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<PEDIDO> readAllVoluntario (@PathParam("id") String id) {
			return PEDIDODAOImplementation.getInstance().readAllVoluntario(id);
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response create(PEDIDO pnew) throws URISyntaxException {
			PEDIDO p = PEDIDODAOImplementation.getInstance().create(pnew);
			if (p != null) {
				URI uri = new URI("/BarrioCovid-SERVICE/rest/PEDIDOs/" + p.getComprador());
					return Response.created(uri).build();
		    }
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		@DELETE
		@Path("{id}")
		public Response delete(@PathParam("id") String id) {
			PEDIDO rold = PEDIDODAOImplementation.getInstance().read(id);
			if (rold == null)
				return Response.notModified().build();
			PEDIDODAOImplementation.getInstance().delete(rold);
			return Response.ok().build();
		}

}

