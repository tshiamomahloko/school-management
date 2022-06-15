package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnrolmentID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "ModuleID")
    private Module moduleId;

    @Column(name = "Term")
    private String term;
    
}
