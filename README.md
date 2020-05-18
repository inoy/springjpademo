# Spring Boot JPA ノート

Udemy の Spring & Hibernate for Beginners (includes Spring Boot)　に沿った内容

## OneToOne

[Section 23: Hibernate Advanced Mappings -
@OneToOne](https://hitachijp3.udemy.com/course/spring-hibernate-tutorial/learn/lecture/7667986#overview)

テーブル instructor, instructor_detail を用意しこれに関連を設定する。

// instructor_detail_id を instructor テーブルに持つのが個人的には違和感がある...。  
// instructor_detail に instructor_id を持たせるほうが良いのかなと現段階では思う。

```
CREATE TABLE `instructor` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) DEFAULT NULL,
    `last_name` VARCHAR(50) DEFAULT NULL,
    `email` VARCHAR(50) DEFAULT NULL,
    `instructor_detail_id` INT DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail`(`id`)
);
```

```
CREATE TABLE `instructor_detail` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `youtube_channel` VARCHAR(128) DEFAULT NULL,
    `hobby` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
```

以下のエンティティを定義する。  
@OneToOne で関連を指定。@JoinColumn の name で JOIN に使う(自テーブルの)カラムを指定。  
これは単方向 Instructor -> InstructorDetail の定義。

```
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

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;
}
```

```
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
}
```

双方向 InstructorDetail -> Instructor を追加する場合，以下。

```
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor()
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

    @OneToOne(mappedBy = "instructorDetail")
    @Setter
    private Instructor instructor;

    public InstructorDetail(int id, String youtubeChannel, String hobby) {
        this.id = id;
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
```
