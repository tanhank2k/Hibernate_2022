package dao;

import hibernate.HibernateUtils;
import model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseDAO {

    private SessionFactory sessionFactory;
    public CourseDAO(){
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }
    public void addCourse(Course course){
        Session session = sessionFactory.openSession();
        session.save(course);
        session.close();
        sessionFactory.getCurrentSession().save(course);
    }
    public void updateCourse(Course course){
        Session session = sessionFactory.openSession();
        session.update(course);
        session.close();
    }
    public void deleteCourse(Course course){
        Session session = sessionFactory.openSession();
        session.delete(course);
        session.close();
    }
    public Course getCourseById(int id){
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }
    public List<Course> getListCourse(){
        Session session = sessionFactory.openSession();
        List<Course> courses = session.createQuery("from Course").list();
        session.close();
        return courses;
    }
}
