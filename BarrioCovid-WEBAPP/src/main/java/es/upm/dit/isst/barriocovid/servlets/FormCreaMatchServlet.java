package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;

/**
 * Servlet implementation class FormCreaTFGServlet
 */
@WebServlet("/FormCreaMatchServlet")
public class FormCreaMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

@Override

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String Vendedor = req.getParameter("Vendedor");
        String Voluntario = req.getParameter("Voluntario");

                BarrioCovid registro = new BarrioCovid();
             //  registro.setEmail(req.getParameter("email"));
                registro.setVoluntario(req.getParameter("Voluntario"));
                registro.setVendedor(req.getParameter("Vendedor"));
                Client client = ClientBuilder.newClient(new ClientConfig());
               Response r = client.target(URLHelper.getURL()).request()
                        .post(Entity.entity(registro, MediaType.APPLICATION_JSON)
                       , Response.class);
                if (r.getStatus() == 200) {
                        req.getSession().setAttribute("registro", registro);
                        getServletContext().getRequestDispatcher("/Admin.jsp")
                              .forward(req, resp);
                        return;

               }        

        getServletContext().getRequestDispatcher("/Admin.jsp").forward(req, resp);

}
}