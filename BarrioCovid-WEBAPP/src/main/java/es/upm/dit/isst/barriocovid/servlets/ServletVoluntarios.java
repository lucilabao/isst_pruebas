package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVoluntarios
 */
@WebServlet("/ServletVoluntarios")
@DeclareRoles("voluntario")
@ServletSecurity(@HttpConstraint(rolesAllowed={"voluntario"}))
public class ServletVoluntarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException, IOException {
           req.getSession().invalidate();
            getServletContext().getRequestDispatcher("/voluntario.jsp").forward(req,resp);
    }

}
