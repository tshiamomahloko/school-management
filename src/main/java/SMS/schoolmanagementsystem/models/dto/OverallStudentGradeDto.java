package SMS.schoolmanagementsystem.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OverallStudentGradeDto {


    private String name;
    private String surname;
    private String email;
    private String moduleName;
    private float gradeObtained;

    public OverallStudentGradeDto(String name, String surname, String email, String moduleName, float gradeObtained) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.moduleName = moduleName;
        this.gradeObtained = gradeObtained;

    }
}
