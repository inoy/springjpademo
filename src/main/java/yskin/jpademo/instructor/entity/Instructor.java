package yskin.jpademo.instructor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String last_name;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;
}
