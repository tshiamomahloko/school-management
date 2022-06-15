package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModuleID")
    private int moduleId;

    @Column(name = "ModuleName")
    private String moduleName;

    @Column(name = "ModuleDescription")
    private String moduleDescription;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course courseID;

}
