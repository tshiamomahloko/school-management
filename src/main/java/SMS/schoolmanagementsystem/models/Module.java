// package SMS.schoolmanagementsystem.models;

// @Entity
// //@Table(name = "Course")
// @Getter
// @Setter
// public interface Module {
// }

package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Table(name = "Course")
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ModuleID")
    private int moduleId;

    @Column(name = "ModuleName")
    private String moduleName;

    @Column(name = "ModuleDescription")
    private String moduleDescription;
    
    @Column(name = "CourseID")
    private int courseId;
}