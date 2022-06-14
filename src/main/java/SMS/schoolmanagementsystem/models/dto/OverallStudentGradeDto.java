package SMS.schoolmanagementsystem.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OverallStudentGradeDto {

    private String name;
    private String surname;
    private String email;
    private String moduleName;
    private float gradeObtained;

}
