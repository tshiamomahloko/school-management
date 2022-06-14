package SMS.schoolmanagementsystem.models;

import lombok.*;

import javax.persistence.*;
import java.text.MessageFormat;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
