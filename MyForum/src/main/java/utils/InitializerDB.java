package main.java.utils;

import main.java.dao.PostsDAO;
import main.java.dao.SubjectsDAO;
import main.java.dao.UsersDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class InitializerDB implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent arg0) {

    }

    public void requestInitialized(ServletRequestEvent arg0) {
        EntityManager em = DBConfig.createEntityManager();
        UsersDAO usersDAO = new UsersDAO(em);
        SubjectsDAO subjectsDAO = new SubjectsDAO(em);
        PostsDAO postsDAO = new PostsDAO(em);
        ServletRequest request = arg0.getServletRequest();
        request.setAttribute("postsDAO", postsDAO);
        request.setAttribute("subjectsDAO", subjectsDAO);
        request.setAttribute("usersDAO", usersDAO);
    }

}
