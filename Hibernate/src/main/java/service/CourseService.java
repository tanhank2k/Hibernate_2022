package service;

import dao.*;
import model.*;

import java.util.List;

public class CourseService {
    private UserDAO userDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private RoomDAO roomDAO;
    private CourseStudentDAO courseStudentDAO;
    private AttendanceCourseDAO attendanceCourseDAO;

    public CourseService(){
        this.userDAO = new UserDAO();
        this.studentDAO = new StudentDAO();
        this.courseDAO = new CourseDAO();
        this.roomDAO = new RoomDAO();
        this.courseStudentDAO = new CourseStudentDAO();
        this.attendanceCourseDAO = new AttendanceCourseDAO();
    }

    public Course createNewCourse(Course course){
        courseDAO.addCourse(course);
        return course;
    }

    public List<Course> getListCourse (){
        return courseDAO.getListCourse();
    }

    public List<Room> getListRoom(){
        return roomDAO.getAllRooms();
    }

    public List<Student> getListStudent(){
        return studentDAO.getAllStudents();
    }

    public List<CourseStudent> getListCourseStudent(){
        return courseStudentDAO.getAllCourseStudents();
    }

    public List<AttendanceCourse> getListAttendanceCourse(){
        return attendanceCourseDAO.getAttendanceCourses();
    }
}
