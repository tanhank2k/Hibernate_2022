package model;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}
