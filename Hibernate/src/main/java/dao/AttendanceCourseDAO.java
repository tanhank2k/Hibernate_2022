package dao;

import hibernate.HibernateUtils;
import model.AttendanceCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AttendanceCourseDAO {
    private SessionFactory sessionFactory;
    public AttendanceCourseDAO(){
        sessionFactory = HibernateUtils.getSessionFactory();
    }
    public void addAttendanceCourse(AttendanceCourse attendanceCourse){
        Session session = sessionFactory.openSession();
        session.save(attendanceCourse);
        session.close();
    }
    public void deleteAttendanceCourse(AttendanceCourse attendanceCourse){
        Session session = sessionFactory.openSession();
        session.save(attendanceCourse);
        session.close();
        sessionFactory.getCurrentSession().delete(attendanceCourse);
    }
    public void updateAttendanceCourse(AttendanceCourse attendanceCourse){
        Session session = sessionFactory.openSession();
        session.save(attendanceCourse);
        session.close();
        sessionFactory.getCurrentSession().update(attendanceCourse);
    }
    public AttendanceCourse getAttendanceCourseById(int id){
        Session session = sessionFactory.openSession();
        AttendanceCourse attendanceCourse = session.get(AttendanceCourse.class, id);
        session.close();
        return attendanceCourse;
    }

    public List<AttendanceCourse> getAttendanceCourses(){
        Session session = sessionFactory.openSession();
        List<AttendanceCourse> attendanceCourses = session.createQuery("from AttendanceCourse").list();
        session.close();
        return attendanceCourses;
    }

    public List<AttendanceCourse> getAttendanceCourseByCourseId(int id){
        Session session = sessionFactory.openSession();
        List<AttendanceCourse> attendanceCourses = session.createQuery("from AttendanceCourse where courseId = :id").setParameter("id", id).list();
        session.close();
        return attendanceCourses;
    }
    public List<AttendanceCourse> getAttendanceCourseByStudentInCourse(int studentId, int courseId){
        Session session = sessionFactory.openSession();
        List<AttendanceCourse> attendanceCourses = session
                .createQuery("from AttendanceCourse where studentId = :studentId and courseId = :courseId")
                .setParameter("studentId", studentId).setParameter("courseId", courseId).list();
        session.close();
        return attendanceCourses;
    }

}
