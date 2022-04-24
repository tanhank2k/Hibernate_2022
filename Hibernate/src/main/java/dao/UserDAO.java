package dao;

import hibernate.HibernateUtils;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO {
    private SessionFactory sessionFactory;
    public UserDAO (){
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    public void addUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
    public User getUser(int id){
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }
    public List<User> getAllUser(){
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
    public User signIn(String username, String password, String role){
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User where username = '" + username + "' and password = '" + String.valueOf(password.hashCode()) + "' and role = '" + role + "'").list();
        session.close();
        if (users.size() > 0)
            return users.get(0);
        else
            return null;
    }
}
