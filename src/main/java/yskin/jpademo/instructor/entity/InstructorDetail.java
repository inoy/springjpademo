package yskin.jpademo.instructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String youtubeChannel;

    @Column
    private String hobby;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    @Setter
    private Instructor instructor;

    public InstructorDetail(int id, String youtubeChannel, String hobby) {
        this.id = id;
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
