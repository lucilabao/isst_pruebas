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
			List<BarrioCovid> listaCovid = client.target(URLHelper.getURL())
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<BarrioCovid>>() {
					});
			System.out.println(listaCovid);
			req.setAttribute("listaCovid", listaCovid);
			getServletContext().getRequestDispatcher("/Admin.jsp")
					.forward(req, resp);
			return;
		}
		getServletContext().getRequestDispatcher("/index.html").forward(req, resp);

	}

}