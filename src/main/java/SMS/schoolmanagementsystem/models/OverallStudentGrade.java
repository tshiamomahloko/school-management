package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OverallStudentGrade {


    private String name;
    private String surname;
    private String email;
    private String moduleName;
    private float gradeObtained;

    public OverallStudentGrade(String name, String surname, String email, String moduleName, float gradeObtained) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.moduleName = moduleName;
        this.gradeObtained = gradeObtained;

    }
}
