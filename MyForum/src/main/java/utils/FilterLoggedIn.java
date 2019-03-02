package main.java.utils;

import main.java.dao.UsersDAO;
import main.java.entities.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class FilterLoggedIn implements Filter {


    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;

        req.setCharacterEncoding("UTF-8");
        String login = req.getRemoteUser();

        if (login != null) {
            User u = (User)req.getSession().getAttribute("user");
            if (u == null) {
                UsersDAO dao = (UsersDAO)req.getAttribute("usersDAO");
                u = dao.getAfterLogin(login);
                req.getSession().setAttribute("user", u);
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
