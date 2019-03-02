package main.java.servlets;

import main.java.dao.UsersDAO;
import main.java.entities.User;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if (login != null && password != null && password2 != null && password.equals(password2) && !"".equals(password)) {
            UsersDAO dao = (UsersDAO)request.getAttribute("usersDAO");

            try {
                dao.getAfterLogin(login);
                request.setAttribute("error", "That's login already exist!");
                doGet(request, response);
                return;
            } catch (NoResultException nre) {
                User u = new User();
                u.setLogin(login);
                u.setPassword(password);
                if (dao.addUser(u)) {
                    response.sendRedirect(request.getContextPath() + "/index");
                } else {
                    request.setAttribute("error", "Can't finish registration!");
                }
            }

        } else {
            request.setAttribute("error", "Error login data!");
            doGet(request, response);
        }
    }

}
