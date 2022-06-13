package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AssessmentID", nullable = false)
    private int assessmentId;

    @Column(name = "AssessmentType")
    private String assessmentType;

    @ManyToOne
    @JoinColumn(name = "ModuleID")
    private Module moduleId;

    @Column(name = "AssessmentDescription")
    private String assessmentDescription;

    @Column(name = "AssessmentWeight")
    private int assessmentWeight;

}
