package model;

import common.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;
    private String dateOfWeek;
    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
    private Status status;
    private Integer duration;
    private String image;
    private String createdBy;
    private String createdDate;
    private String updatedBy;
    private String updatedDate;
    @OneToMany(mappedBy = "course")
    private List<CourseStudent> courseStudent;
}
