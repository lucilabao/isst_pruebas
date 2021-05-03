package es.upm.dit.isst.pedido.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
		//@GET
		//@Path("professor/{id}")
		//@Produces(MediaType.APPLICATION_JSON)
		//public List<TFG> readAll (@PathParam("id") String id) {
		//	return TFGDAOImplementation.getInstance().readAll(id);
		//}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response create(PEDIDO pnew) throws URISyntaxException {
			PEDIDO p = PEDIDODAOImplementation.getInstance().create(pnew);
			if (p != null) {
				URI uri = new URI("/COVID-SERVICE/rest/PEDIDOs/" + p.getComprador());
					return Response.created(uri).build();
		    }
			return Response.status(Response.Status.NOT_FOUND).build();
		}
}

