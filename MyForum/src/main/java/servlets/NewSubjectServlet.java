package main.java.servlets;

import main.java.dao.SubjectsDAO;
import main.java.entities.Subject;
import main.java.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;

@WebServlet(value = "/newSubject")
public class NewSubjectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/newSubject.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (!"".equals(title) && !"".equals(content)) {
            Timestamp t = new Timestamp(new Date().getTime());
            User loggedIn = (User)request.getSession().getAttribute("user");
            SubjectsDAO dao = (SubjectsDAO)request.getAttribute("subjectsDAO");
            Subject subject = new Subject();
            subject.setDate(t);
            subject.setContent(content);
            subject.setTitle(title);
            subject.setUser(loggedIn);
            if (dao.addSubject(subject)) {
                response.sendRedirect(request.getContextPath() + "/subject?id=" + subject.getId());
            }
        }
    }
}
