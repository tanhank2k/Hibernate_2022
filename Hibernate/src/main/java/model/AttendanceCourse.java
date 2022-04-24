package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AttendanceCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(targetEntity = CourseStudent.class)
    @JoinColumn(name = "course_student_id", referencedColumnName = "id")
    private CourseStudent courseStudent;
    private int courseStudentId;
    private int week;
    private Date date;
    private boolean attendance;

}
