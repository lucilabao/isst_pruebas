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
import es.upm.dit.isst.barriocovid.servlets.URLHelper;

/**
 * Servlet implementation class FormCreaPedidoServlet
 */
@WebServlet("/FormCreaPedidoServlet")
public class FormCreaPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaPedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	    String email = req.getParameter("email");
            String emailVendedor = req.getParameter("emailVendedor");
        //    int status = req.getParameter("status");
                    BarrioCovid registro = new BarrioCovid();
                    registro.setEmail(email);
                    registro.setVendedor(emailVendedor);
                    registro.setStatus(0);                             
                    Client client = ClientBuilder.newClient(new ClientConfig());
                   Response r = client.target(URLHelper.getURL()).request()
                            .post(Entity.entity(registro, MediaType.APPLICATION_JSON)
                           , Response.class);
                    if (r.getStatus() == 201) {
                            req.getSession().setAttribute("registro", registro);
                            getServletContext().getRequestDispatcher("/Comprador.jsp")
                                  .forward(req, resp);
                            return;
                    }
            }        
 

    }
    

