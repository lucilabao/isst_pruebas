package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;
import es.upm.dit.isst.barriocovid.servlets.URLHelper;

/**
 * Servlet implementation class FormAdminServlet
 */
@WebServlet("/FormAdminServlet")
public class FormAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()      ESTO ES DE BarrioCovid
     */
    public FormAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// autorizacion: check root

		String email = request.getParameter("email");

		Client client = ClientBuilder.newClient(new ClientConfig());

		BarrioCovid registro = null;

		try {

			registro = client.target(URLHelper.getURL() + "/" + email)
					.request().accept(MediaType.APPLICATION_JSON).get(BarrioCovid.class);

		} catch (Exception e) {
		}

		if (registro != null) {
			registro.setVendedor(request.getParameter("Vendedor"));
			registro.setVoluntario(request.getParameter("Voluntario"));
			registro.setStatus(Integer.parseInt(request.getParameter("status")));
			client.target(URLHelper.getURL() + "/" + email)

					.request()

					.post(Entity.entity(registro, MediaType.APPLICATION_JSON), Response.class);

			List<BarrioCovid> lista_final = client.target(URLHelper.getURL())

					.request().accept(MediaType.APPLICATION_JSON)

					.get(new GenericType<List<BarrioCovid>>() {
					});

			request.setAttribute("lista_final", lista_final);

		}

		getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);

	}

}
