package dao;

import hibernate.HibernateUtils;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAO {
    private SessionFactory sessionFactory;
    public StudentDAO(){
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.save(student);
        session.close();
    }

    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.update(student);
        session.close();
    }

    public void deleteStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.delete(student);
        session.close();
    }

    public Student getStudentById(int id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        session.close();
        return students;
    }
    public List<Student> getAllStudentInCourse(int id) {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student where course_id = "+id).list();
        session.close();
        return students;
    }
}
