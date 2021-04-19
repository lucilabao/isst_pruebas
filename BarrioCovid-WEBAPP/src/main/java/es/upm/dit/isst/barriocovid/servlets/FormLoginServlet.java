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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;


/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 *      Password se usara por mayor seguridad posteriormente ESTO ES DE BarrioCOVID
	 */

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String rol = req.getParameter("rol");
		Client client = ClientBuilder.newClient(new ClientConfig());
		// autenticacion1
		if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
			req.getSession().setAttribute("admin", true);
			List<BarrioCovid> lista_final = client.target(URLHelper.getURL())
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<BarrioCovid>>() {
					});
			System.out.println(lista_final);
			req.setAttribute("lista_final", lista_final);
			System.out.println("traza 1");
			getServletContext().getRequestDispatcher("/Admin.jsp")
			.forward(req, resp);
			System.out.println("traza 2");
			return;
		} 

		if (rol.indexOf("comprador") > -1) {
			req.getSession().setAttribute("comprador", rol);
			List<BarrioCovid> listaComprador = client.target(URLHelper.getURL()
					+ "/usuario/" + email)
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<BarrioCovid>>() {
					});
			req.setAttribute("listaComprador", listaComprador);
			getServletContext().getRequestDispatcher("/Comprador.jsp")
					.forward(req, resp);
			return;
		}
		
		else if (rol.indexOf("vendedor") > -1) {
			req.getSession().setAttribute("vendedor", rol);
			List<BarrioCovid> listaCompradores = client.target(URLHelper.getURL()
					+ "/usuario/" + email)
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<BarrioCovid>>() {
					});
			req.setAttribute("listaCompradores", listaCompradores);
			getServletContext().getRequestDispatcher("/Vendedor.jsp")
					.forward(req, resp);
			return;
		}
		
		else if (rol.indexOf("voluntario") > -1) {
			req.getSession().setAttribute("voluntario", rol);
			List<BarrioCovid> listaVoluntario= client.target(URLHelper.getURL()
					+ "/usuario/" + email)
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<BarrioCovid>>() {
					});
			req.setAttribute("listaVoluntario", listaVoluntario);
			getServletContext().getRequestDispatcher("/Voluntario.jsp")
					.forward(req, resp);
			return;
		}

		getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
		
	}

}