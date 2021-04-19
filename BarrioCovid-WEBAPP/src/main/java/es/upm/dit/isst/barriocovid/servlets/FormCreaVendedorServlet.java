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
 * Servlet implementation class FormCreaVendedorServlet
 */
@WebServlet("/FormCreaVendedorServlet")
public class FormCreaVendedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaVendedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// autorizacion: check root

		String email = request.getParameter("email");
		System.out.println(email);
		Client client = ClientBuilder.newClient(new ClientConfig());

		BarrioCovid registro = null;

		try {

			System.out.println(URLHelper.getURL() + "usuario/" + email);
			registro = client.target(URLHelper.getURL() + "usuario/" + email)

					
					.request().accept(MediaType.APPLICATION_JSON).get(BarrioCovid.class);

		} catch (Exception e) {
		}

		if (registro != null) {

			registro.setVendedor(request.getParameter("Vendedor"));

			client.target(URLHelper.getURL() + "usuario/" + email)

					.request()

					.post(Entity.entity(registro, MediaType.APPLICATION_JSON), Response.class);


		}

		getServletContext().getRequestDispatcher("/Vendedor.jsp").forward(request, response);

	}
}