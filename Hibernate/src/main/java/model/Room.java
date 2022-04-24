package model;

import common.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String createBy;
    private Date createTime;
    private Status status;
    @OneToOne
    private Course course;
}
