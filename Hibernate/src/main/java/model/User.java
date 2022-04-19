package model;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String role;
    private String status;
    private String fullname;
    private String avatar;
    private String birthday;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
