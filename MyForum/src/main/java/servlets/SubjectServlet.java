package main.java.servlets;

import main.java.dao.PostsDAO;
import main.java.dao.SubjectsDAO;
import main.java.entities.Post;
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

@WebServlet(value = "/subject")
public class SubjectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        String stringId = request.getParameter("id");
        if (stringId != null) {
            int id = Integer.parseInt(stringId);
            SubjectsDAO dao = (SubjectsDAO)request.getAttribute("subjectsDAO");
            Subject subject = dao.getSubject(id);
            request.setAttribute("subject", subject);
            request.getRequestDispatcher("WEB-INF/view/subject.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String content = request.getParameter("content");
        String stringId = request.getParameter("id");
        if (content != null && stringId != null) {
            int id = Integer.parseInt(stringId);
            PostsDAO postsDAO = (PostsDAO)request.getAttribute("postsDAO");
            SubjectsDAO subjectsDAO = (SubjectsDAO)request.getAttribute("subjectsDAO");
            User loggedIn = (User)request.getSession().getAttribute("user");
            Subject subject = subjectsDAO.getSubject(id);
            Post post = new Post();
            post.setDate(new Timestamp(new Date().getTime()));
            post.setContent(content);
            post.setUser(loggedIn);
            post.setSubject(subject);
            postsDAO.addPost(post);
        }
        doGet(request, response);
    }

}
