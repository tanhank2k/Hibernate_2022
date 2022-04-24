package dao;

import hibernate.HibernateUtils;
import model.CourseStudent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseStudentDAO {
    private SessionFactory sessionFactory;
    public CourseStudentDAO(){
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }
    public void addCourseStudent(CourseStudent courseStudent){
        Session session = sessionFactory.openSession();
        session.save(courseStudent);
        session.close();
    }
    public void updateCourseStudent(CourseStudent courseStudent){
        Session session = sessionFactory.openSession();
        session.update(courseStudent);
        session.close();
    }
    public void deleteCourseStudent(CourseStudent courseStudent){
        Session session = sessionFactory.openSession();
        session.delete(courseStudent);
        session.close();
    }
    public CourseStudent getCourseStudent(int id){
        Session session = sessionFactory.openSession();
        CourseStudent courseStudent = session.get(CourseStudent.class, id);
        session.close();
        return courseStudent;
    }

    public List<CourseStudent> getAllCourseStudents(){
        Session session = sessionFactory.openSession();
        List<CourseStudent> courseStudents = session.createQuery("from CourseStudent").list();
        session.close();
        return courseStudents;
    }

    public void addCourseStudents(CourseStudent[] courseStudents){
        Session session = sessionFactory.openSession();
        for(CourseStudent courseStudent: courseStudents){
            session.save(courseStudent);
        }
        session.close();

    }
}
