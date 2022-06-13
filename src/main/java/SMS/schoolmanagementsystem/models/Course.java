package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Table(name = "Course")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CourseID")
    private int courseId;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "CourseDescription")
    private String courseDescription;
}
