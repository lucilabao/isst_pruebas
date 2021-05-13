package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormLogoutServlet")
public class FormLogoutServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                      throws ServletException, IOException {
        		//Anula la sesion
               req.getSession().invalidate();
               //Logout
               req.logout();
               getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
               

        }
}
