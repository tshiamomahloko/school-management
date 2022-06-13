package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGrade extends Users{

    private String moduleName;

    private int assessmentId;

    private String assessmentDescription;

    private float assessmentWeight;

    private float gradeObtained;

}
