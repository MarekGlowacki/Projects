package main.java.dao;

import main.java.entities.Role;
import main.java.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsersDAO {

    private EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public User getAfterLogin(String login) {
        User u = (User)em.createQuery("SELECT u FROM User u WHERE u.login = :login").setParameter("login", login).getSingleResult();
        return u;
    }

    public boolean addUser(User u) {
        u.setPassword(this.getMD5(u.getPassword()));
        Role r = new Role();
        r.setLogin(u.getLogin());
        r.setRole("user");
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(u);
            em.persist(r);
            et.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }

    private String getMD5(String data) {
        MessageDigest md5;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        md5.update(data.getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());
        String ready = hash.toString(16);
        if (ready.length() == 31) {
            ready = "0" + ready;
        }
        return ready;
    }

}