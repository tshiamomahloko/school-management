package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Grade;
import SMS.schoolmanagementsystem.models.OverallStudentGrade;

import java.util.ArrayList;
import java.util.List;

public class GradeService {

    public static OverallStudentGrade getOverallGrade(List<Grade> studentGrades) {
        
        String name = "";
        String surname = "";
        String email = "";
        String moduleName = "";
        float assessmentResult = 0;
        float finalGrade = 0;
        List<Float> assessmentResults = new ArrayList<Float>();
        OverallStudentGrade moduleGrade = null;

        for (Grade grade : studentGrades) {

            name = grade.getGradeId().getEnrolmentId().getUserId().getName();
            surname = grade.getGradeId().getEnrolmentId().getUserId().getSurname();
            email = grade.getGradeId().getEnrolmentId().getUserId().getEmailAddress();
            moduleName = grade.getGradeId().getEnrolmentId().getModuleId().getModuleName();
            float assessmentWeight = grade.getGradeId().getAssessmentId().getAssessmentWeight();
            float gradeObtained = grade.getGradeObtained();

            assessmentResult = gradeObtained * (assessmentWeight / 100);
            assessmentResults.add(assessmentResult);
        }



        for (float result : assessmentResults) {
            finalGrade = finalGrade + result;
        }

        moduleGrade = new OverallStudentGrade(name, surname, email, moduleName, finalGrade);

        return moduleGrade;
    }
}
